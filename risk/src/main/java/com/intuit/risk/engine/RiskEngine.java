package com.intuit.risk.engine;

import com.intuit.common.PaymentRequest;
import com.intuit.risk.db.Payment;
import com.intuit.risk.db.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RiskEngine {
    @Autowired
    private PaymentRepository paymentRepository;

    public void handleRiskAlgorithm(PaymentRequest paymentRequest){
        String status = "";
        if(Math.random() < 0.7){
            status = "Passed";
        }else{
            status = "failed";
        }

        Payment payment = new Payment(paymentRequest);
        payment.setStatus(status);
        paymentRepository.save(payment);
    }
}
