package com.cloud.controller.handler;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import jdk.nashorn.internal.ir.Block;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/14 12:42
 */
public class myBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444,"自定义global handlerException");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444,"自定义global handlerException2222222");
    }
}
