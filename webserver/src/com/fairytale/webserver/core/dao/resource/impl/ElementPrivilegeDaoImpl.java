package com.fairytale.webserver.core.dao.resource.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.resource.ElementPrivilegeDao;
import com.fairytale.webserver.core.entity.resource.ElementPrivilege;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��23��
 */
@Repository("elementPrivilegeDao")
public class ElementPrivilegeDaoImpl extends HibernateGenericDaoImpl<ElementPrivilege, Long> implements ElementPrivilegeDao<ElementPrivilege, Long> {

}
