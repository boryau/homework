package com.intuit.risk.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {

    public TopicListener() {
    }

    @KafkaListener(topics = "test", groupId = "foo")
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
    }
}
