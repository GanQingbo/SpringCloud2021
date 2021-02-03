package com.cloud.controller;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import com.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author G
 * @version 1.0
 * @date 2021/1/20 11:50
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    //服务发现
    @Resource
    private DiscoveryClient discoveryClient;

    //写操作用post，不加requestbody消费者调用会插入null
    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果:"+result);
        if(result>0){
            return new CommonResult(200,"插入成功,port:"+serverPort,result);
        }else {
            return new CommonResult(400,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("查询结果："+payment.getSerial()+"hello");
        if(payment!=null){
            return new CommonResult(200,"查询成功,port:"+serverPort,payment);
        }else {
            return new CommonResult(400,"没有对应记录，查询的id是："+id,null);
        }
    }

    //服务发现
    @GetMapping(value = "/payment/discovery")
    public Object discvery(){
        List<String> services = discoveryClient.getServices();
        for(String s:services){
            log.info("***element:"+s);
        }
        //获取微服务的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    //超时测试
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
