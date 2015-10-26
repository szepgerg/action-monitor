package com.gergo.actionmonitor.controller;

import com.gergo.actionmonitor.ActionMonitorApplication;
import com.gergo.actionmonitor.domain.User;
import com.gergo.actionmonitor.domain.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by gergo on 2015.10.26..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ActionMonitorApplication.class)
public class UserControllerTest {

	@Autowired
	UserController userController;
	@Autowired
	UserRepository userRepository;

	@Before
	public void setUp() {
		userRepository.deleteAll();
		User user = new User("id0", "name0");
		userRepository.save(user);
	}

	@Test
	public void testInsert() throws Exception {
		User user = new User("id1", "name1");
		ResponseEntity<?> responseEntity = userController.insert(user);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		User erroneous = new User("id0", "name0Wrong");
		responseEntity = userController.insert(erroneous);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
	}

	@Test
	public void testUpdate() throws Exception {
		User user = new User("id0", "name0Updated");
		ResponseEntity<?> responseEntity = userController.update(user);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		User erroneous = new User("id2", "name2");
		responseEntity = userController.update(erroneous);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
	}

	@After
	public void tearDown() {
		userRepository.deleteAll();
	}
}