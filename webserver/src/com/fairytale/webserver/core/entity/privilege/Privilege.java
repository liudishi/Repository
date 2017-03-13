package com.fairytale.webserver.core.entity.privilege;

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
@Table(name="T_PRIVILEGE_PRIVILEGE")
public class Privilege implements Serializable{

	
	/**
	 * �汾���
	 */
	private static final long serialVersionUID = 8616933214843424152L;
	//Ȩ��ID
	@Id
	@Column(name="privilege_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long privilegeId;
	//Ȩ������
	@Column(name="type")
	private String type;
	
	public Long getPrivilegeId() {
		return privilegeId;
	}
	
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
