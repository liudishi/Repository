package com.fairytale.webserver.core.dao.resource.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.resource.OperationPrivilegeDao;
import com.fairytale.webserver.core.entity.resource.OperationPrivilege;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��23��
 */
@Repository("operationPrivilegeDao")
public class OperationPrivilegeDaoImpl extends HibernateGenericDaoImpl<OperationPrivilege, Long> implements OperationPrivilegeDao<OperationPrivilege, Long> {

}
