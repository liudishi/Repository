package com.fairytale.webserver.core.entity.resource;

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
@Table(name="T_RESOURCE_OPERATION")
public class Operation implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = 1538939226724367502L;

	@Id
	@Column(name="operation_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long operationId;
	@Column(name="name")
	private String name;
	
	public Long getOperationId() {
		return operationId;
	}
	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
