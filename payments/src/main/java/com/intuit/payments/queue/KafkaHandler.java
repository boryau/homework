package com.intuit.payments.queue;

import com.intuit.common.PaymentRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaHandler {
    @Autowired
    private KafkaTemplate<String, PaymentRequest> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    private static final Logger logger = LogManager.getLogger(KafkaHandler.class);

    public void sendMessage(PaymentRequest request){
        logger.info("KafkaHandler sendMessage start");
        logger.info("KafkaHandler topic is " + topic);
        kafkaTemplate.send(topic, request);
        logger.info("KafkaHandler sendMessage end");
    }
}
