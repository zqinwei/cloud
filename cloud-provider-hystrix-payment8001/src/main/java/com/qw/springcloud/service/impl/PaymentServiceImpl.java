package com.qw.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qw.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    public String paymentInfoOk(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + ",paymentInfoOk:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeOut(Integer id) {
        int timeNumber = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + ",paymentInfoTimeOut:" + id + ",timeNumber:" + timeNumber;
    }

    public String paymentInfoTimeOutHandle(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + ",paymentInfoTimeOut:" + id + ",gg";
    }


    //----服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率
    })
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0){
            throw new RuntimeException("id不能为负数");
        }
        return "线程池:" + Thread.currentThread().getName() + ",paymentCircuitBreaker:success" + ",uuid:"+ IdUtil.simpleUUID();
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return "paymentCircuitBreakerFallback gg" + id;
    }
}
