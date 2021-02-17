package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;



/**
 * @author G
 * @version 1.0
 * @date 2021/2/11 20:36
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        try{
            TimeUnit.MICROSECONDS.sleep(900);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return "this is testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "this is testB";
    }

    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("this is testD");
        return "this is testD";
    }

    @GetMapping("/testC")
    public String testC(){
        log.info("this  is testC");
        int age=10/0;
        return "this is testC";
    }

    //热点key
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,@RequestParam(value = "p2",required = false) String p2){
        return "this is testHotKey";
    }
    //兜底方法
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        //sentinel默认是Blocked by Sentinel（flow limiting）
        return "this is deal testHotKey";
    }
}
