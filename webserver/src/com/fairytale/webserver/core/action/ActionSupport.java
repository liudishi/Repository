package com.fairytale.webserver.core.action;

/**
 * Copyright (c) 2014 Canton Fairy tale Commercial Co.,Ltd.
 * @author Liudishi
 * 2014年9月4日
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
