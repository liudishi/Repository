package com.fairytale.webserver.core.action;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��9��4��
 */
public class ActionSupport {

	private FtpRequest ftpRequest;

	public ActionSupport() {
	}

	public FtpRequest getFtpRequest() {
		return ftpRequest;
	}

	public void setFtpRequest(FtpRequest ftpRequest) {
		this.ftpRequest = ftpRequest;
	}

}
