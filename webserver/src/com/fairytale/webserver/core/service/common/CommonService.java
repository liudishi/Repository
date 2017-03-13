package com.fairytale.webserver.core.service.common;

import java.util.List;

import com.fairytale.webserver.core.entity.common.DataDictionary;
import com.fairytale.webserver.netty.common.Page;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * ͨ�ù����࣬���ڻ�ȡϵͳ������ݣ���������ֵ��
 * @author Liudishi
 * 2014��8��28��
 */
public interface CommonService {

	/**
	 * ��ݲ�ѯ������ȡ����ֵ��б�
	 * @param dataDictionary
	 * @param page
	 * @return ��������ֵ��б�
	 */
	public List<DataDictionary> findDataDictionary(DataDictionary dataDictionary, Page page);
}
