/**
 * 
 */
package com.fairytale.webserver.core.service.privilege;

import com.fairytale.webserver.core.entity.privilege.Privilege;

/**
 * @author Liudishi
 * 2014��8��22��
 */
public interface PrivilegeService {

	public Long addPrivilege(Privilege privilege);
	
	public void deletePrivilege(Long id);
}
