package com.intuit.risk.listener;

import com.intuit.common.PaymentRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {

    public TopicListener() {
    }

    @KafkaListener(topics = "test", groupId = "foo")
    public void listen(PaymentRequest message) {
        System.out.println("Received Messasge in group foo: " + message);
    }
}
