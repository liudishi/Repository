package com.fairytale.webserver.core.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fairytale.webserver.core.service.common.CommonService;
import com.fairytale.webserver.core.dao.common.DataDictionaryDao;
import com.fairytale.webserver.core.entity.common.DataDictionary;
import com.fairytale.webserver.netty.common.Page;

/**
 * @author Liudishi
 * 2014��8��28��
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {

	Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);
	
	@Resource
	DataDictionaryDao<DataDictionary, Long> dataDictionaryDao;

	public DataDictionaryDao<DataDictionary, Long> getDataDictionaryDao() {
		return dataDictionaryDao;
	}

	public void setDataDictionaryDao(
			DataDictionaryDao<DataDictionary, Long> dataDictionaryDao) {
		this.dataDictionaryDao = dataDictionaryDao;
	}

	public List<DataDictionary> findDataDictionary(
			DataDictionary dataDictionary, Page page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
