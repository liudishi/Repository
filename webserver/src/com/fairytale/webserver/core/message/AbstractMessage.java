package com.fairytale.webserver.core.message;

import java.io.Serializable;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��29��
 */
public abstract class AbstractMessage implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = 5893139381581907326L;

	public AbstractMessage(){
		
	}
	
	private int sequence;

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
}
