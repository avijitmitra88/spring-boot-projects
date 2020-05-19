package com.springpractice;

import javax.annotation.PostConstruct;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
public class JmsConsumerExampleApplication {
	
	  
	  @JmsListener(destination = "NewTestMQ") 
	  public void consume(String message) {
		  System.out.println("message : " + message);
	  }
	 

	public static void main(String[] args) {
		SpringApplication.run(JmsConsumerExampleApplication.class, args);
	}

}
