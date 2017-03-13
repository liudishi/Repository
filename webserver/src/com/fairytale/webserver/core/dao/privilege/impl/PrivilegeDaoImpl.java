package com.fairytale.webserver.core.dao.privilege.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.privilege.PrivilegeDao;
import com.fairytale.webserver.core.entity.privilege.Privilege;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��22��
 */
@Repository("privilegeDao")
public class PrivilegeDaoImpl extends HibernateGenericDaoImpl<Privilege, Long> implements PrivilegeDao<Privilege, Long> {

}
