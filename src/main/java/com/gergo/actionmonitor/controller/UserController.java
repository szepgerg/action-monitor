package com.gergo.actionmonitor.controller;

import com.gergo.actionmonitor.domain.User;
import com.gergo.actionmonitor.domain.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gergo on 2015.10.25..
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> insert(@RequestBody User user) {
		logger.info("Received JSON data to insert: " + user);
		try {
			userService.insertUser(user);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception ex) {
			logger.error("Exception while trying to insert user.", ex);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = RequestMethod.PUT)
	ResponseEntity<?> update(@RequestBody User user) {
		logger.info("Received JSON data to update: " + user);
		try {
			userService.updateUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception while trying to update user.", ex);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
