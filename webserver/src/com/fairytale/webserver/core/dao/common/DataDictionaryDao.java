package com.fairytale.webserver.core.dao.common;

import java.util.List;

import com.fairytale.webserver.core.entity.common.DataDictionary;
import com.fairytale.webserver.core.dao.base.HibernateGenericDao;
import com.fairytale.webserver.core.dao.base.PaginationSupport;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��28��
 */
public interface DataDictionaryDao<T,ID> extends HibernateGenericDao<T, ID> {

	/**
	 * ���������ѯ����ֵ��б�
	 * @param page
	 * @param dataDictionary
	 * @return ��������ֵ��б�
	 */
	public List<DataDictionary> findDataDictionaryList(DataDictionary dataDictionary, PaginationSupport paginationSupport);
}
