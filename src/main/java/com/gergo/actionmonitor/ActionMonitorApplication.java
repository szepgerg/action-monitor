package com.gergo.actionmonitor;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * Created by gergo on 2015.10.25..
 */
@SpringBootApplication
@EnableJms
public class ActionMonitorApplication {

	private static final Logger logger = LoggerFactory.getLogger(ActionMonitorApplication.class);

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("action-monitor.queue");
	}

	public static void main(String[] args) {
		logger.info("Starting Action Monitor application.");
		ConfigurableApplicationContext ctx = SpringApplication.run(ActionMonitorApplication.class, args);
	}

}
