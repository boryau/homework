package com.intuit.risk;

import com.intuit.risk.db.Payment;
import com.intuit.risk.db.PaymentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DBTest {

    @Autowired
    private PaymentRepository paymentRepsoitory;

    @Test
	public void testDB(){
        Payment payment = new Payment();
        payment.setAmount(new Double(10.5));
        payment.setCurrency("USD");
        payment.setPayeeId("FFF");
        payment.setPaymentMethodId("VISA");
        payment.setStatus("FAILED");
        payment.setUserId("DDD");

        paymentRepsoitory.save(payment);

        List<Payment> payments = paymentRepsoitory.findByUserId("DDD");
        assertTrue(payments.size() == 1);

        paymentRepsoitory.delete(payment);
        payments = paymentRepsoitory.findByUserId("DDD");
        assertTrue(payments.size() == 0);
	}

}
