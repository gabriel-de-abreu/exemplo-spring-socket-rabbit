package com.websocket.demo.listener;

import com.rabbitmq.client.Channel;
import com.websocket.demo.dto.ExampleMessageDTO;
import com.websocket.demo.service.SocketSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitListenerExample {

    private final SocketSenderService socketSenderService;

    @RabbitListener(queues = "FILA.TESTE.INP")
    public void receiveMesage(Message message, Channel channel, long tag) throws IOException {
        String text = new String(message.getBody());
        log.info("Recebendo mensagem - {}", text);
        socketSenderService.sendMessageToController(text);
    }
}
