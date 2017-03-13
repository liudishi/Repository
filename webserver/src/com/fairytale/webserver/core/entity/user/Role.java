package com.fairytale.webserver.core.entity.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author Liudishi
 * 2014��8��24��
 */
@Entity
@Table(name="T_USER_ROLE")
public class Role implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = 6154271794851834417L;

	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roleId;
	@Column(name="role_name")
	private String roleName;
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public List<Authority> getAuthorityList(){
		List<Authority> authorities = new ArrayList<Authority>();
		return authorities;
	}
}
