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
 *
 */
@Entity
@Table(name="T_RESOURCE_ELEMENT")
public class Element implements Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = 2559476660028416738L;

	@Id
	@Column(name="element_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long elementId;
	@Column(name="name")
	private String Name;
	
	public Long getElementId() {
		return elementId;
	}
	public void setElementId(Long elementId) {
		this.elementId = elementId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
}
