/**
 * 
 */
package com.fairytale.webserver.core.service.resource.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fairytale.webserver.core.dao.resource.ElementDao;
import com.fairytale.webserver.core.entity.resource.Element;
import com.fairytale.webserver.core.service.resource.ElementService;

/**
 * @author Liudishi
 * 2014��8��23��
 */
@Service("elementService")
public class ElementServiceImpl implements ElementService {

	@Resource
	private ElementDao<Element, Long> elementDao;
	
	
	public ElementDao<Element, Long> getElementDao() {
		return elementDao;
	}


	public void setElementDao(ElementDao<Element, Long> elementDao) {
		this.elementDao = elementDao;
	}


	/* (non-Javadoc)
	 * @see com.yuyan.server.core.service.resource.ElementService#addElement(com.yuyan.server.core.entity.resource.Element)
	 */
	public Long addElement(Element element) {
		// TODO Auto-generated method stub
		return elementDao.save(element);
	}

}
