/**
 * 
 */
package com.fairytale.webserver.core.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.user.GroupDao;
import com.fairytale.webserver.core.entity.user.Group;

/**
 * @author Liudishi
 * 2014��8��23��
 */
@Repository("groupDao")
public class GroupDaoImpl extends HibernateGenericDaoImpl<Group, Long> implements
		GroupDao<Group, Long> {

}
