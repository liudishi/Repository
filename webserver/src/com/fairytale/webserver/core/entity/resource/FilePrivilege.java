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
@Table(name="T_RESOURCE_FILE_PRIVILEGE")
public class FilePrivilege implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = 8028894709373627137L;

	@Id
	@Column(name="file_privilege_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long filePrivilegeId;
	@Column(name="file_id")
	private Long fileId;
	@Column(name="privilegeId")
	private Long privilegeId;
	
	public Long getFilePrivilegeId() {
		return filePrivilegeId;
	}
	public void setFilePrivilegeId(Long filePrivilegeId) {
		this.filePrivilegeId = filePrivilegeId;
	}
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public Long getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	
	
}
