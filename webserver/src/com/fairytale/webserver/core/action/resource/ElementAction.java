/**
 * 
 */
package com.fairytale.webserver.core.action.resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.fairytale.webserver.core.entity.resource.Element;
import com.fairytale.webserver.core.service.resource.ElementService;

/**
 * @author Liudishi
 * 2014��8��23��
 */
@Controller("elementAction")
public class ElementAction {

	@Resource
	private ElementService elementService;

	public ElementService getElementService() {
		return elementService;
	}

	public void setElementService(ElementService elementService) {
		this.elementService = elementService;
	}
	
	public Long doAdd(Element element){
		return elementService.addElement(element);
	}
}
