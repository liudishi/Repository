package com.fairytale.webserver.core.dao.resource.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.resource.FileDao;
import com.fairytale.webserver.core.entity.resource.File;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��23��
 */
@Repository("fileDao")
public class FileDaoImpl extends HibernateGenericDaoImpl<File, Long> implements FileDao<File, Long> {

}
