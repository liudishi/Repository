package com.fairytale.webserver.netty.common;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��28��
 */
public class Page implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = 4909421630525807758L;

	Logger logger = LoggerFactory.getLogger(Page.class);
	
	private Integer rows = 1;//ÿҳ��ʾ������
	private Integer page = 1;//��ʼ��ѯ��ҳ�룬Ĭ�ϴӵ�һ�濪ʼ
	private Integer recordCount = 0;//����¼¦
	private Integer pageCount = 0;//��ҳ��
	private String sort;//�����ֶ�
	private String order;//asc,desc
	
	public Page() {
		// TODO Auto-generated constructor stub
	}
	
	public Page(String page,
			String rows,
			String sort,
			String order){
		if(StringUtils.isNotBlank(page)
				&& StringUtils.isNotBlank(rows)){
			this.page = Integer.valueOf(page);
			this.rows = Integer.valueOf(rows);
			this.sort = sort;
			this.order = order;
		}
	}

	/**
	 * ��ݿ��ѯʱ���ӵڼ�����¼��ʼ��ѯ
	 * @return
	 */
	public int getFirstResult(){
		pageCount=getPageCount();
		if(page<=0){
			page=1;
		}else if(page>pageCount){
			page=pageCount;
		}
		return (page-1)*rows;
	}
	
	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * ��ȡ��ҳ��
	 * @return ������ҳ��
	 */
	public Integer getPageCount() {
		return recordCount % rows == 0 ? recordCount/rows : recordCount / rows + 1;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
}
