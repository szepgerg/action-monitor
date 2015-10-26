package com.gergo.actionmonitor.dto;

/**
 * Created by gergo on 2015.10.25..
 */
public class HealthStatus {

	private String status;

	public HealthStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
