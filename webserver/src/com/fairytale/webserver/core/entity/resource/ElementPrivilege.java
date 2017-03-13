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
@Table(name="T_RESOURCE_ELEMENT_PRIVILEGE")
public class ElementPrivilege implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = 153788580527066137L;

	@Id
	@Column(name="element_privilege_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long elementPrivilegeId;
	@Column(name="element_id")
	private Long elementId;
	@Column(name="privilege_id")
	private Long privilegeId;
	
	public Long getElementPrivilegeId() {
		return elementPrivilegeId;
	}
	public void setElementPrivilegeId(Long elementPrivilegeId) {
		this.elementPrivilegeId = elementPrivilegeId;
	}
	public Long getElementId() {
		return elementId;
	}
	public void setElementId(Long elementId) {
		this.elementId = elementId;
	}
	public Long getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	
}
