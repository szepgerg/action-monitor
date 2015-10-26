package com.gergo.actionmonitor.dto;

import java.io.Serializable;

/**
 * Created by gergo on 2015.10.25..
 */
public class DBOperationDTO implements Serializable {

	public enum OperationType {
		INSERT, UPDATE
	}

	private long timestamp;
	private String id;
	private OperationType operationType;

	public DBOperationDTO() {

	}

	public DBOperationDTO(long timestamp, String id, OperationType operationType) {
		this.timestamp = timestamp;
		this.id = id;
		this.operationType = operationType;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	@Override
	public String toString() {
		return "DBOperationDTO[timestamp=" + timestamp +
				", id=" + id +
				", operationType=" + operationType + "]";
	}
}
