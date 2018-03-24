package com.intuit.risk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RiskApplicationTests {


	@KafkaListener(topics = "test", groupId = "foo")
	public void listen(String message) {
		System.out.println("Received Messasge in group foo: " + message);
	}
	@Test
	public void contextLoads() {
	}

}
