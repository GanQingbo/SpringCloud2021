package com.cloud.service.impl;

import com.cloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/7 21:50
 */
//不用service,Source是stream包的，定义消息的推送管道
@EnableBinding(Source.class)
public class MessageProvider implements IMessageProvider {
    @Resource
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("******serial:"+serial);
        return null;
    }
}
