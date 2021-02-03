package com.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: SpringCloud2021
 * @description:
 * @author: Gan
 * @date: 2021-02-03 16:36
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "=====paymentFallbackService,ok---------";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "=====paymentFallbackService, timeout---------";
    }
}
