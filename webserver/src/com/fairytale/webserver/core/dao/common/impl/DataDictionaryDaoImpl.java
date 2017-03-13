package com.fairytale.webserver.core.dao.common.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.base.PaginationSupport;
import com.fairytale.webserver.core.dao.common.DataDictionaryDao;
import com.fairytale.webserver.core.entity.common.DataDictionary;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��28��
 */
@Repository("dataDictionaryDao")
public class DataDictionaryDaoImpl extends HibernateGenericDaoImpl<DataDictionary, Long> implements DataDictionaryDao<DataDictionary, Long> {

	public List<DataDictionary> findDataDictionaryList(DataDictionary dataDictionary, PaginationSupport paginationSupport) {
		// ���ò�ѯ����
		Criteria criteria = getHibernateTemplate().getSessionFactory().openSession().createCriteria(dataDictionary.getClass());
		
		criteria.setFirstResult(paginationSupport.getStartIndex());
		criteria.setMaxResults(paginationSupport.getPageSize());
		
		return (List<DataDictionary>) findByCriteria(criteria);
	}
}
