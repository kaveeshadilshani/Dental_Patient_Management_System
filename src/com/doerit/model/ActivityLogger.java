package com.doerit.model;

import java.util.Date;

public class ActivityLogger {

	 public enum MessageType {
		    SIGN_IN, SIGNOUT, PASSWORD_REQUEST, PASSWORD_CHANGED, PASSWORD_EMAILED, 
		    ADMIN_WARD, ADMIN_THEATER, MEET_DOCTOR, PHARMACY_VISIT;
	 }	 
	 
	private String id;
	private String relateKey;
	private String messageType;
	private String message;
	private String accessHost;
	private String insertUserId;
	private String updateUserId;
	private Date insertDatetime;
	private Date updateDatetime;
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getRelateKey() {
		return relateKey;
	}

	public void setRelateKey(String relateKey) {
		this.relateKey = relateKey == null ? null : relateKey.trim();
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType == null ? null : messageType.trim();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message == null ? null : message.trim();
	}

	public String getAccessHost() {
		return accessHost;
	}

	public void setAccessHost(String accessHost) {
		this.accessHost = accessHost == null ? null : accessHost.trim();
	}

	public String getInsertUserId() {
		return insertUserId;
	}

	public void setInsertUserId(String insertUserId) {
		this.insertUserId = insertUserId == null ? null : insertUserId.trim();
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId == null ? null : updateUserId.trim();
	}

	public Date getInsertDatetime() {
		return insertDatetime;
	}

	public void setInsertDatetime(Date insertDatetime) {
		this.insertDatetime = insertDatetime;
	}

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}