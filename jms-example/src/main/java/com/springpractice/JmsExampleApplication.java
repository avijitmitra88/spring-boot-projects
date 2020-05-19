package com.springpractice;

import javax.annotation.PostConstruct;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
public class JmsExampleApplication {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	Queue queue;
	
	@PostConstruct
	public void produce() {
		jmsTemplate.convertAndSend(queue, "How are you?");
	}

	public static void main(String[] args) {
		SpringApplication.run(JmsExampleApplication.class, args);
	}

}
