package com.fairytale.webserver.core.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.user.RolePrivilegeDao;
import com.fairytale.webserver.core.entity.user.RolePrivilege;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��23��
 */
@Repository("rolePrivilegeDao")
public class RolePrivilegeDaoImpl extends HibernateGenericDaoImpl<RolePrivilege, Long> implements RolePrivilegeDao<RolePrivilege, Long> {

}
