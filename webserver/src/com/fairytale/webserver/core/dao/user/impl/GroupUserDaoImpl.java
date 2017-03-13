/**
 * 
 */
package com.fairytale.webserver.core.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.user.GroupUserDao;
import com.fairytale.webserver.core.entity.user.GroupUser;

/**
 * @author Liudishi
 * 2014��8��23��
 */
@Repository("groupUserDao")
public class GroupUserDaoImpl extends HibernateGenericDaoImpl<GroupUser, Long> implements
		GroupUserDao<GroupUser, Long> {

}
