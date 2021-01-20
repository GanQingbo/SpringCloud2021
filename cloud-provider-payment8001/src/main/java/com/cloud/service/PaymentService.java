package com.cloud.service;

import com.cloud.entities.Payment;

/**
 * @author G
 * @version 1.0
 * @date 2021/1/20 11:42
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
