package com.doerit.action;

import java.io.InputStream;

public abstract class AbstractFileAction extends AbstractManagementAction {

	private static final long serialVersionUID = 1L;
	
	private InputStream fileStream;
	private String fileName;
	
	public InputStream getFileStream() {
		return fileStream;
	}

	public void setFileStream(InputStream fileStream) {
		this.fileStream = fileStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
