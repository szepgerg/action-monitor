package com.gergo.actionmonitor.controller;

import com.gergo.actionmonitor.dto.DBOperationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * Created by gergo on 2015.10.25..
 */
@Controller
public class ActionMonitorController {

	private static final Logger logger = LoggerFactory.getLogger(ActionMonitorController.class);

	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping("/monitor")
	public void dbOperationDTO(DBOperationDTO dbOperationDTO)
			throws Exception {
		logger.info("Sending DBOperationDTO to client: " + dbOperationDTO);
		this.template.convertAndSend("/topic/action-monitor", dbOperationDTO);
	}

}
