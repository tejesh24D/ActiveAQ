package com.example.activemqdemo.listener;



import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = "test-queue") // Ensure this matches the queue name
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}

