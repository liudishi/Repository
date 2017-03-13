package com.fairytale.webserver.core.entity.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Copyright (c) 2016 Canton Fairy tale Co.,Ltd.
 * @author Liudishi
 * 2016�?�?�?
 */
@Entity
@Table(name="T_DATA_DICTIONARY")
public class DataDictionary implements Serializable {

	/**
	 * 版本编号
	 */
	private static final long serialVersionUID = -1247842283154981302L;
	@Id
	@Column(name="DATA_DICTIONARY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long dataDictionaryId;
	@Column(name="KEY")
	private String key;//�?
	@Column(name="VALUE")
	private String value;//�?
	@Column(name="TEXT")
	private String text;//文本
	@Column(name="DELETED")
	private String deleted;//删除标志
	@Column(name="ORDER")
	private Integer order;//排序
	
	public Long getDataDictionaryId() {
		return dataDictionaryId;
	}
	public void setDataDictionaryId(Long dataDictionaryId) {
		this.dataDictionaryId = dataDictionaryId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
}
