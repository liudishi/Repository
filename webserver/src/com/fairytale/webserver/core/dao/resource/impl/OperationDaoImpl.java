package com.fairytale.webserver.core.dao.resource.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.resource.OperationDao;
import com.fairytale.webserver.core.entity.resource.Operation;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��23��
 */
@Repository("operationDao")
public class OperationDaoImpl extends HibernateGenericDaoImpl<Operation, Long> implements OperationDao<Operation, Long> {

}
