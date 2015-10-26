package com.gergo.actionmonitor.controller;

import com.gergo.actionmonitor.dto.HealthStatus;
import com.gergo.actionmonitor.dto.Version;
import com.gergo.actionmonitor.util.VersionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gergo on 2015.10.25..
 */
@RestController
public class HealthController {

	private static final Logger logger = LoggerFactory.getLogger(HealthController.class);

	@Autowired
	private VersionProvider versionProvider;

	@RequestMapping("/healthy")
	public HealthStatus healthStatus() {
		logger.info("Requested application health.");
		return new HealthStatus("OK");
	}

	@RequestMapping("/version")
	public Version getApplicationVersion() {
		logger.info("Requested application version.");
		String version = this.versionProvider.getApplicationVersion();
		return new Version(version);
	}

}
