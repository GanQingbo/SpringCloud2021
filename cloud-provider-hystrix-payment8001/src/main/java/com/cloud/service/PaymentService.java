package com.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @program: SpringCloud2021
 * @description: 省略了接口
 * @author: Gan
 * @date: 2021-02-02 15:57
 **/
@Service
public class PaymentService {
    //正常的方法
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo OK,id:"+id+"\t";
    }
    //出错的方法，添加注解，超过3秒就兜底
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber=3;
        //int age=10/0   运行出错一样走paymentInfo_TimeOutHandler
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();;
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfo Timeout,id:"+id+"\t 耗时："+timeNumber;
    }
    //兜底
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+" -----兜底-----,id:"+id;
    }

    //======服务熔断=======
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期,10秒
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少熔断
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("======id不能小于0");
        }
        String serialNumber= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功："+serialNumber;
    }
    //兜底方法
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return  "id不能小于0，请稍后再试:"+id;
    }
}
