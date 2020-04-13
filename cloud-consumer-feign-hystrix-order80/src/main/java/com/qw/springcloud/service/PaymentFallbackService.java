package com.qw.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "PaymentFallbackService paymentInfoOk fall back";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "PaymentFallbackService paymentInfoTimeout fall back";
    }
}
