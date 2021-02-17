package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.controller.handler.myBlockHandler;
import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/14 11:17
 */
@RestController
@Slf4j
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2020L,"serial001"));
    }
    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按url限流测试ok",new Payment(2021L,"serial002"));
    }

    @GetMapping("/rateLimit/myBlockHandler")
    @SentinelResource(value="myBlockHandler",blockHandlerClass = myBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult myBlockHandler(){
        return new CommonResult(200,"自定义测试ok",new Payment(2021L,"serial003"));
    }
}
