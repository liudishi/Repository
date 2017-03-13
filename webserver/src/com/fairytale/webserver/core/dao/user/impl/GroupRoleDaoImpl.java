/**
 * 
 */
package com.fairytale.webserver.core.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.user.GroupRoleDao;
import com.fairytale.webserver.core.entity.user.GroupRole;

/**
 * @author Liudishi
 * 2014��8��23��
 */
@Repository("groupRoleDao")
public class GroupRoleDaoImpl extends HibernateGenericDaoImpl<GroupRole, Long> implements
		GroupRoleDao<GroupRole, Long> {

}
