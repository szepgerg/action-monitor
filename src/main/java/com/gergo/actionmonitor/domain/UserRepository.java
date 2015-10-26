package com.gergo.actionmonitor.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by gergo on 2015.10.25..
 */
public interface UserRepository extends MongoRepository<User, String> {
}
