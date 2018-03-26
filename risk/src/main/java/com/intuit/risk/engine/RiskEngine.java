package com.intuit.risk.engine;

import com.intuit.common.PaymentRequest;
import com.intuit.risk.db.Payment;
import com.intuit.risk.db.PaymentRepository;
import com.intuit.risk.queue.listener.TopicListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RiskEngine {
    @Autowired
    private PaymentRepository paymentRepository;

    private static final Logger logger = LogManager.getLogger(RiskEngine.class);

    /**
     * Risk engine algorithm
     * @param paymentRequest
     */
    public void handleRiskAlgorithm(PaymentRequest paymentRequest){
        logger.info("RiskEngine handleRiskAlgorithm start");
        String status = "";
        if(Math.random() < 0.7){
            status = "Passed";
        }else{
            status = "Failed";
        }
        logger.debug("RiskEngine handleRiskAlgorithm status set to " + status);
        Payment payment = new Payment(paymentRequest);
        payment.setStatus(status);
        paymentRepository.save(payment);
        logger.info("RiskEngine handleRiskAlgorithm end");
    }
}
