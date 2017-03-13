package com.fairytale.webserver.core.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author Liudishi
 *
 */
@Entity
@Table(name="T_ROLE_PRIVILEGE")
public class RolePrivilege implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = -2989115331460561193L;

	@Id
	@Column(name="role_privilege_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rolePrivilegeId;
	@Column(name="role_id")
	private Long roleId;
	@Column(name="privilege")
	private Long privilegeId;
	public Long getRolePrivilegeId() {
		return rolePrivilegeId;
	}
	public void setRolePrivilegeId(Long rolePrivilegeId) {
		this.rolePrivilegeId = rolePrivilegeId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	
}
