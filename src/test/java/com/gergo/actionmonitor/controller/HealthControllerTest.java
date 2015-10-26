package com.gergo.actionmonitor.controller;

import com.gergo.actionmonitor.ActionMonitorApplication;
import com.gergo.actionmonitor.dto.HealthStatus;
import com.gergo.actionmonitor.dto.Version;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by gergo on 2015.10.26..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ActionMonitorApplication.class)
public class HealthControllerTest {

	@Autowired
	HealthController healthController;

	@Test
	public void testHealthStatus() throws Exception {
		HealthStatus healthStatus = healthController.healthStatus();
		assertEquals("OK", healthStatus.getStatus());
	}

	@Test
	public void testGetApplicationVersion() throws Exception {
		Version version = healthController.getApplicationVersion();
		assertNotNull(version.getVersionNum());
	}
}