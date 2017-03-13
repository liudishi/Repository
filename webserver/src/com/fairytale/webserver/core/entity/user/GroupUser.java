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
@Table(name="T_USER_GROUP_USER")
public class GroupUser implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = -9046534957009869278L;

	@Id
	@Column(name="group_user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long groupUserId;
	@Column
	private Long groupId;
	@Column
	private Long userId;
	
	public Long getGroupUserId() {
		return groupUserId;
	}
	public void setGroupUserId(Long groupUserId) {
		this.groupUserId = groupUserId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
