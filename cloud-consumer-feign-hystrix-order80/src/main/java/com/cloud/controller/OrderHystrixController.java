package com.cloud.controller;

import com.cloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: SpringCloud2021
 * @description: controller
 * @author: Gan
 * @date: 2021-02-02 18:35
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    //@HystrixCommand   //需要兜底的都加？
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentInfo_OK(id);
        return result;
    }
    //开启Hystrix
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }
    public String paymentTimeOutFallbackMethod(@PathVariable("id")Integer id){
        return "消费者80：支付服务系统超时或运行出错";
    }
    //全局fallback
    public String paymentGlobalFallback(){
        return "Global异常信息，请稍后再试";
    }
}
