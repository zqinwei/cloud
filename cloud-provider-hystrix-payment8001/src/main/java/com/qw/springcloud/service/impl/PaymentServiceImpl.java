package com.qw.springcloud.service.impl;

import com.qw.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + ",paymentInfoOk:" + id;
    }
}
