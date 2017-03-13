package com.fairytale.webserver.core.action;

import org.json.JSONObject;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��9��4��
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
