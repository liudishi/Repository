package com.fairytale.webserver.core.dao.base;

import java.util.List;

public interface HibernateGenericDao<T,ID> {

	/**
     * �½�����ʵ��
     */
	public ID save(T transientInstance);
	
	/**
     * �����Ѵ��ڵĶ���
     */
	public void update(T transientInstance);
	
	/**
     * ɾ��ָ������
     */
    public void delete(T persistentInstance);

    /**
     * ���ID��ѯ�������
     */
    public T findById(ID id);
    
    /**
     * ���ĳ���������Խ��в���
     */
    public List<T> findByProperty(String propertyName, Object value);
    
    /**
	 * �����Բ�ѯ�����������û���¼��֤��
	 * @param properties �����������
	 * @param values ��������ֵ
	 * @return
	 */
	public List<T> findByProperties(String[] properties, Object[] values);
	
    /**
     * ��ݸ��ʵ����Ҷ���
     */
    public List<T> findByExample(T instance);
}
