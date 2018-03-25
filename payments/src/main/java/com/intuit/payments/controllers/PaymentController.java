package com.intuit.payments.controllers;


import com.intuit.common.PaymentRequest;
import com.intuit.payments.data.PaymentResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "payment")
public class PaymentController {
    private static final Logger logger = LogManager.getLogger(PaymentController.class);

    @RequestMapping(value = "sendpayment", method = RequestMethod.POST)
    public @ResponseBody PaymentResponse sendPayment(@RequestBody PaymentRequest paymentRequest){
        PaymentResponse response = new PaymentResponse();
        analyzePayment(paymentRequest);

        response.setResponse("Payment Acknowledged");

        return response;
    }


    /**
     * Analyze the payment before rerouting it to Queue
     * @param paymentRequest
     */
    private void analyzePayment(PaymentRequest paymentRequest) {

    }
}
