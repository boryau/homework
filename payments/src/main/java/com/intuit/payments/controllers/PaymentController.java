package com.intuit.payments.controllers;


import com.intuit.common.PaymentRequest;
import com.intuit.payments.data.PaymentResponse;
import com.intuit.payments.queue.KafkaHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "payment")
public class PaymentController {
    private static final Logger logger = LogManager.getLogger(PaymentController.class);

    @Autowired
    private KafkaHandler kafkaHandler;

    @RequestMapping(value = "sendpayment", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity sendPayment(@Valid @RequestBody PaymentRequest paymentRequest, BindingResult result){
        logger.info("PaymentController.sendPayment start");
        if(result.hasErrors()){
            String errorMessage = result.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        //PaymentResponse response = new PaymentResponse();

        kafkaHandler.sendMessage(paymentRequest);

        //response.setResponse("Payment Acknowledged");
        logger.info("PaymentController.sendPayment end");
        return ResponseEntity.status(HttpStatus.OK).body("Payment Acknowledged");
    }


}
