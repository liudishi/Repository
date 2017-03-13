package com.fairytale.webserver.core.action.privilege;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.fairytale.webserver.core.entity.privilege.Privilege;
import com.fairytale.webserver.core.service.privilege.PrivilegeService;

/**
 * @author Liudishi
 * 2014��8��22��
 */
@Controller
public class PrivilegeAction {

	@Resource
	private PrivilegeService privilegeService;
	
	public PrivilegeService getPrivilegeService() {
		return privilegeService;
	}

	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	public Long add(Privilege privilege){
		return this.privilegeService.addPrivilege(privilege);
	}
}
