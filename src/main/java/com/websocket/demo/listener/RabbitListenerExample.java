package com.websocket.demo.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Slf4j
@Component
public class RabbitListenerExample {

    @RabbitListener(queues = "FILA.TESTE.INP")
    public void receiveMesage(Message message, Channel channel, long tag) throws IOException {
        log.info("Recebendo mensagem - {}", new String(message.getBody()));
    }
}
