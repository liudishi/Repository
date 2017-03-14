package com.fairytale.webserver.core.action;

import org.json.JSONObject;

/**
 * Copyright (c) 2014 Canton Fairy tale Commercial Co.,Ltd.
 * @author Liudishi
 * 2014年9月4日
 */
public class FtpRequest {

	private JSONObject requestJson;
	
	public FtpRequest() {
	}

	public JSONObject getRequestJson() {
		return requestJson;
	}
	public void setRequestJson(JSONObject requestJson) {
		this.requestJson = requestJson;
	}

}
