package com.fairytale.webserver.core.dao.resource.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.resource.FilePrivilegeDao;
import com.fairytale.webserver.core.entity.resource.FilePrivilege;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��23��
 */
@Repository("filePrivilegeDao")
public class FilePrivilegeDaoImpl extends HibernateGenericDaoImpl<FilePrivilege, Long> implements FilePrivilegeDao<FilePrivilege, Long> {

}
