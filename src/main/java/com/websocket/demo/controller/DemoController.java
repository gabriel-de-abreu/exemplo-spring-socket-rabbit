package com.websocket.demo.controller;

import com.websocket.demo.dto.ExampleMessageDTO;
import com.websocket.demo.service.SocketSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo-controller")
public class DemoController {

    private final SocketSenderService socketSenderService;

    @GetMapping("/test")
    public ResponseEntity<String> testController() {
        return ResponseEntity.ok("Hello there!");
    }

    @PostMapping("/send-message")
    public ResponseEntity<Void> postMessageToSocketSubscriber(@RequestBody ExampleMessageDTO exampleMessageDTO) {
        socketSenderService.sendMessageToController(exampleMessageDTO);
        return ResponseEntity.ok().build();
    }
}
