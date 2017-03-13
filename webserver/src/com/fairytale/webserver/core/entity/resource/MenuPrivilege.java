package com.fairytale.webserver.core.entity.resource;

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
 * 2014��8��22��
 */
@Entity
@Table(name="T_RESOURCE_MENU_PRIVILEGE")
public class MenuPrivilege implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = -4350771304760691622L;

	@Id
	@Column(name="menu_privilege_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long menuPrivilegeId;
	@Column(name="menu_id")
	private Long menuId;
	@Column(name="privilege")
	private Long privilegeId;
	
	public Long getMenuPrivilegeId() {
		return menuPrivilegeId;
	}
	public void setMenuPrivilegeId(Long menuPrivilegeId) {
		this.menuPrivilegeId = menuPrivilegeId;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public Long getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	
}
