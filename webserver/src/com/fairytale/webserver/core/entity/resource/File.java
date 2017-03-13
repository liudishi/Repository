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
@Table(name="T_RESOURCE_FILE")
public class File implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = -3391203562022934464L;

	@Id
	@Column(name="file_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long fileId;
	@Column(name="name")
	private String name;
	@Column(name="path")
	private String path;
	
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
