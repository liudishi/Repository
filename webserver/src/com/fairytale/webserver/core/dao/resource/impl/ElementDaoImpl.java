package com.fairytale.webserver.core.dao.resource.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.resource.ElementDao;
import com.fairytale.webserver.core.entity.resource.Element;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��22��
 */
@Repository("elementDao")
public class ElementDaoImpl extends HibernateGenericDaoImpl<Element, Long> implements ElementDao<Element, Long> {

}
