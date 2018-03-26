package com.intuit.risk.listener;

import com.intuit.common.PaymentRequest;
import com.intuit.risk.engine.RiskEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {

    private static final Logger logger = LogManager.getLogger(TopicListener.class);
    @Autowired
    private RiskEngine riskEngine;

    public TopicListener() {
    }

    @KafkaListener(topics = "${kafka.topic}", groupId = "foo")
    public void listen(PaymentRequest message) {
        logger.info("TopicListener listen start");
        logger.info("Received Messasge in group foo: " + message);
        riskEngine.handleRiskAlgorithm(message);
        logger.info("TopicListener listen end");
    }
}
