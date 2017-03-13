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
@Table(name="T_USER_GROUP")
public class Group implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = 3142751326586944020L;

	@Id
	@Column(name="group_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long groupId;
	@Column(name="group_name")
	String groupName;
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
