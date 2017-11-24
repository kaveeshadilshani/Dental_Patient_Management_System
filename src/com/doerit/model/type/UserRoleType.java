package com.doerit.model.type;

public enum UserRoleType {
	
	ADMIN("ADMIN"),
	DENTAL_DOCTOR("DENTAL_DOCTOR"),
	HEALTH_MINISTRY_DOCTOR("HEALTH_MINISTRY_DOCTOR"),
	DENTAL_NURSE("DENTAL_NURSE"),
	HEALTH_MINISTRY_NURSE("HEALTH_MINISTRY_NURSE"),
	CLERK("CLERK"),
	TECHNICIAN("TECHNICIAN"),
	POSTGRADUATE_STUDENT("POSTGRADUATE_STUDENT"),
	STUDENT("STUDENT"),
	DEPARTMENT("DEPARTMENT");
	
	private String dbId;
	
	UserRoleType(String dbId) {
		this.setDbId(dbId);
	}	
	
	public String getDbId() {
		return dbId;
	}

	public void setDbId(String dbId) {
		this.dbId = dbId;
	}	
}
