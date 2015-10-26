package com.gergo.actionmonitor.domain;

import com.gergo.actionmonitor.dto.DBOperationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Queue;

/**
 * Created by gergo on 2015.10.25..
 */

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserRepository userRepository;

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		userRepository.deleteAll();
	}

	@Override
	public User insertUser(User user) {
		logger.info("Inserting new user: " + user);
		User test = userRepository.findOne(user.getId());
		if (test != null) {
			throw new IllegalStateException("User already present in the db: " + test);
		}
		User inserted = userRepository.insert(user);
		logger.info("Inserted new user: " + user);
		this.sendMessages(System.currentTimeMillis(), inserted.getId(), DBOperationDTO.OperationType.INSERT);
		return inserted;
	}

	@Override
	public User updateUser(User user) {
		logger.info("Updating existing user: " + user);
		User test = userRepository.findOne(user.getId());
		if (test == null) {
			throw new IllegalStateException("Could not find user in db: " + user);
		}
		User updated = userRepository.save(user);
		logger.info("Updated existing user: " + user);
		sendMessages(System.currentTimeMillis(), updated.getId(), DBOperationDTO.OperationType.UPDATE);
		return updated;
	}


	private void sendMessages(long timestamp, String id, DBOperationDTO.OperationType type) {
		DBOperationDTO dbOperationDTO = new DBOperationDTO(timestamp, id, type);
		logger.info("Sending message to queue...");
		jmsMessagingTemplate.convertAndSend(this.queue, dbOperationDTO);
	}
}
