/**
 * 
 */
package com.fairytale.webserver.core.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.fairytale.webserver.core.dao.base.HibernateGenericDaoImpl;
import com.fairytale.webserver.core.dao.user.RoleDao;
import com.fairytale.webserver.core.entity.user.Role;

/**
 * @author Liudishi
 * 2014��8��23��
 */
@Repository("roleDao")
public class RoleDaoImpl extends HibernateGenericDaoImpl<Role, Long> implements
		RoleDao<Role, Long> {

}
