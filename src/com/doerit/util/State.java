package com.doerit.util;

public enum State {
	
	ACTIVE((byte)1), DELETED((byte)0), MST_SETTING((byte)5), PERMONENTLY_DELETED((byte)9);
	
	private byte databaseValue = 0;
	
	State(byte dbValue) {
		this.databaseValue = dbValue;
	}

	public byte getDatabaseValue() {
		return databaseValue;
	}

	public void setDatabaseValue(byte databaseValue) {
		this.databaseValue = databaseValue;
	}

	
}
