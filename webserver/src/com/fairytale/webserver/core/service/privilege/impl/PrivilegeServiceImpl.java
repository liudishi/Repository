/**
 * 
 */
package com.fairytale.webserver.core.service.privilege.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fairytale.webserver.core.dao.privilege.PrivilegeDao;
import com.fairytale.webserver.core.entity.privilege.Privilege;
import com.fairytale.webserver.core.service.privilege.PrivilegeService;

/**
 * @author Liudishi
 * 2014��8��22��
 */
@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {

	@Resource
	private PrivilegeDao<Privilege, Long> privilegeDao;
	/* (non-Javadoc)
	 * @see com.yuyan.server.core.service.privilege.PrivilegeService#addPrivilege(com.yuyan.server.core.entity.privilege.Privilege)
	 */
	public Long addPrivilege(Privilege privilege) {
		// TODO Auto-generated method stub
		return this.privilegeDao.save(privilege);
	}

	public void deletePrivilege(Long id) {
		// TODO Auto-generated method stub
		
	}
}
