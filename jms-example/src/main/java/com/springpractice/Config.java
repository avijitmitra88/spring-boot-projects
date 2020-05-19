package com.springpractice;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class Config {
	
	@Value("${activemq.broker-url}")
	private String brokerURL;
	
	@Bean
	public Queue getQueue() {
		return new ActiveMQQueue("NewTestMQ");
	}
	
	@Bean
	public ActiveMQConnectionFactory getActiveMQConnectionFactory() {
		return new ActiveMQConnectionFactory(brokerURL);
	}
	
	@Bean
	public JmsTemplate getJmsTemplate() {
		return new JmsTemplate(getActiveMQConnectionFactory());
	}
	

}
