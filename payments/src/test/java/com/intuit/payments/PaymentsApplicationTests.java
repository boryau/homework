package com.intuit.payments;


import com.intuit.common.PaymentRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentsApplicationTests {

    @Autowired
    private KafkaTemplate<String, PaymentRequest> kafkaTemplate;

    private final CountDownLatch latch = new CountDownLatch(3);

    @Test
	public void sendMessages() {
        PaymentRequest request = new PaymentRequest();
        request.setAmount(new Double(10));
        request.setCurrency("USD");
        request.setPayeeId("USA");
        request.setUserId("CHINA");
        request.setPaymentMethodId("VISA");
        kafkaTemplate.send("test", request);
        request.setPayeeId("UK");
        kafkaTemplate.send("test", request);
        request.setPayeeId("AUSTRALIA");
        kafkaTemplate.send("test", request);
    }

}
