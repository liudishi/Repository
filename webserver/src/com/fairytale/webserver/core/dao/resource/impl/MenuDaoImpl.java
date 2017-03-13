package com.fairytale.webserver.core.dao.resource.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.resource.MenuDao;
import com.fairytale.webserver.core.entity.resource.Menu;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��23��
 */
@Repository("menuDao")
public class MenuDaoImpl extends HibernateGenericDaoImpl<Menu, Long> implements MenuDao<Menu, Long> {

}
