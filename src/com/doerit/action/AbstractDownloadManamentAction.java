package com.doerit.action;

import java.io.ByteArrayInputStream;

public class AbstractDownloadManamentAction extends AbstractManagementAction {

	private static final long serialVersionUID = 1L;
	protected ByteArrayInputStream fileInputStream;
	protected String fileName;

	public ByteArrayInputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(ByteArrayInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
