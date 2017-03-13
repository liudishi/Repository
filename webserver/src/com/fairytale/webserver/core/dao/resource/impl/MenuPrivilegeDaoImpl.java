package com.fairytale.webserver.core.dao.resource.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.resource.MenuPrivilegeDao;
import com.fairytale.webserver.core.entity.resource.MenuPrivilege;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��23��
 */
@Repository("menuPrivilegeDao")
public class MenuPrivilegeDaoImpl extends HibernateGenericDaoImpl<MenuPrivilege, Long> implements MenuPrivilegeDao<MenuPrivilege, Long> {

}
