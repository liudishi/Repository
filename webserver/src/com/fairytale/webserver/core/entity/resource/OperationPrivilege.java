package com.fairytale.webserver.core.entity.resource;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
/**
 * 
 * @author Liudishi
 * 2014��8��22��
 */
@Entity
@Table(name="T_RESOURCE_OPERATION_PRIVILEGE")
public class OperationPrivilege implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = -120955361122246638L;

	@Id
	@Column(name="operationPrivilegeId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long operationPrivilegeId;
	@Column(name="operation_id")
	private Long operationId;
	@Column(name="privilege_id")
	private Long privilegeId;
	
	public Long getOperationPrivilegeId() {
		return operationPrivilegeId;
	}
	public void setOperationPrivilegeId(Long operationPrivilegeId) {
		this.operationPrivilegeId = operationPrivilegeId;
	}
	public Long getOperationId() {
		return operationId;
	}
	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}
	public Long getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	
	
}
