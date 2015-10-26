package com.gergo.actionmonitor.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by gergo on 2015.10.25..
 */
public class User {

	@Id
	private String id;
	private String name;

	public User() {

	}

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "User[id=" + id + ", name=" + name + "]";
	}
}
