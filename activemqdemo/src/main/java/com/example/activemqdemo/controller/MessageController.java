package com.example.activemqdemo.controller;



import com.example.activemqdemo.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/send/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message) {
        jmsTemplate.convertAndSend("test-queue", message);
        return ResponseEntity.ok("Message sent to ActiveMQ!");
    }
}


