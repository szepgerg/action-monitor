package com.gergo.actionmonitor.messaging;

import com.gergo.actionmonitor.controller.ActionMonitorController;
import com.gergo.actionmonitor.dto.DBOperationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by gergo on 2015.10.25..
 */
@Component
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@Autowired
	private ActionMonitorController actionMonitorController;

	@JmsListener(destination = "action-monitor.queue")
	public void receiveQueue(DBOperationDTO dbOperationDTO) throws Exception {
		logger.info("Received message to action-monitor.queue: " + dbOperationDTO);
		this.actionMonitorController.dbOperationDTO(dbOperationDTO);
	}

}
