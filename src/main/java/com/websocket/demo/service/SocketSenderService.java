package com.websocket.demo.service;

import com.websocket.demo.dto.ExampleMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SocketSenderService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public void sendMessageToController(ExampleMessageDTO exampleMessageDTO) {
        log.info("Enviando mensagem via socket - {}", exampleMessageDTO);
        simpMessagingTemplate.convertAndSend("/topic/greetings", exampleMessageDTO.getMessage());
    }
}
