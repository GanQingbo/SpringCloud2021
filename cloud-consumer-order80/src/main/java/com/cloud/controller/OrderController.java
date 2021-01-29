package com.cloud.controller;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author G
 * @version 1.0
 * @date 2021/1/21 9:52
 */
@RestController
@Slf4j
public class OrderController {
    //请求地址先写死
    //public static final String PAYMENT_URL="http://localhost:8001";
    //通过在eureka上注册过的微服务名称调用
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    //使用Resource注入
    @Resource
    private RestTemplate restTemplate;
    //消费者请求用GET方法，底层调用是写用post
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        //三个参数分别为请求地址，请求参数，返回参数
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
