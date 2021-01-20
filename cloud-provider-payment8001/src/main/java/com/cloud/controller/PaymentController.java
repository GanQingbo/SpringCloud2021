package com.cloud.controller;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import com.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author G
 * @version 1.0
 * @date 2021/1/20 11:50
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    //写操作用post
    @PostMapping(value="/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果:"+result);
        if(result>0){
            return new CommonResult(200,"插入成功",result);
        }else {
            return new CommonResult(400,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("查询结果："+payment.getSerial()+"hello");
        if(payment!=null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(400,"没有对应记录，查询的id是："+id,null);
        }
    }
}