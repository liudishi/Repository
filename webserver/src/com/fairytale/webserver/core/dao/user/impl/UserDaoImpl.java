package com.fairytale.webserver.core.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.user.UserDao;
import com.fairytale.webserver.core.entity.user.User;
/**
 * 
 * @author Liudishi
 *
 * @param <T>
 * @param <ID>
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateGenericDaoImpl<User, Long> implements UserDao<User, Long>{

}
