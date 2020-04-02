package com.qw.springcloud.service;

import com.qw.springcloud.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
