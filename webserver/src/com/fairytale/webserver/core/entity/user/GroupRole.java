package com.fairytale.webserver.core.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Table;
/**
 * 
 * @author Liudishi
 *
 */
@Entity
@Table(name="T_USER_GROUP_ROLE")
public class GroupRole implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = -7018751992782030065L;

	@Id
	@Column(name="group_role_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long groupRoleId;
	@Column(name="group_id")
	private Long groupId;
	@Column(name="role_id")
	private Long roleId;
	
	public Long getGroupRoleId() {
		return groupRoleId;
	}
	public void setGroupRoleId(Long groupRoleId) {
		this.groupRoleId = groupRoleId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}
