package com.fairytale.webserver.core.message;

import java.io.Serializable;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��29��
 */
public class CommonMessage extends AbstractMessage implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = 6870992427440340417L;

	private String method;//�����õķ������
	private Class<?> clazz;//�����õ�Class�������ڷ�����÷���
	private Class<?>[] paramTypes = new Class[]{};//�����Ĳ�������
	private Object[] params = new Object[]{};//�����Ĳ���
	
	public CommonMessage() {
		
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Class<?>[] getParamTypes() {
		return paramTypes;
	}

	public void setParamTypes(Class<?>[] paramTypes) {
		this.paramTypes = paramTypes;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}
	
}
