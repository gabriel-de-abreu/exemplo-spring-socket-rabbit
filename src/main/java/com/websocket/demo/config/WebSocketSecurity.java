package com.websocket.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.ChannelInterceptor;

@Slf4j
public class WebSocketSecurity implements ChannelInterceptor {
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        MessageHeaders headers = message.getHeaders();

        String simpMessageType = headers.get("simpMessageType").toString();
        log.info(simpMessageType);

        return ChannelInterceptor.super.preSend(message, channel);
    }
}
