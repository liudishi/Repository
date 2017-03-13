package com.fairytale.webserver.core.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fairytale.webserver.core.entity.user.User;
import com.fairytale.webserver.utils.GenericsUtils;
/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��29��
 */
@SuppressWarnings("all")
public class HibernateGenericDaoImpl<T, ID extends Serializable> extends HibernateDaoSupport implements HibernateGenericDao<T, ID>{

	private Class<T> pojoClass;

	/**
     * ��ø�DAO��Ӧ��POJO����
     */
    public Class<T> getPojoClass() {
        return this.pojoClass;
    }
    
    @Resource
    private SessionFactory sessionFactory;
	
    /**
     * ��ʼ��DAO����ȡPOJO����
     */
    public HibernateGenericDaoImpl() {
//    	this.pojoClass = (Class<T>) ((ParameterizedType) getClass()
//				.getGenericSuperclass()).getActualTypeArguments()[0];
        this.pojoClass = GenericsUtils.getSuperClassGenricType(getClass());
    }
    
    /**
     * ��ø�DAO��Ӧ��POJO������
     */
    public String getPojoClassName() {
        return getPojoClass().getName();
    }

    //���ض���
    
    /**
     * �������еĶ���
     */
    public List<T> loadAll() {
        return (List<T>)getHibernateTemplate().loadAll(getPojoClass());
    }
    
    /**
     * ���hql��ѯ
     *
     * @param values �ɱ����
     */
    public List find(String hql, Object... values) {
        return getHibernateTemplate().find(hql, values);
    }

    /**
     * ����������ض���
     * 
     * @param criteria Criteriaʵ��
     */
    public List<T> findByCriteria(final Criteria criteria) {
        List list = criteria.list(); 
        return transformResults(list);
    }
    
    /**
     * ����������ض���
     * @param detachedCriteria DetachedCriteriaʵ��
     */
    public List<T> findByCriteria(final DetachedCriteria detachedCriteria) {
        return (List<T>) getHibernateTemplate().execute(new HibernateCallback() {
               public Object doInHibernate(Session session) throws HibernateException {
                   Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                   List list = criteria.list(); 
                   return transformResults(list); 
               }
           });
    }
    
    /**
     * ��ݸ��ʵ����Ҷ���
     */
    public List<T> findByExample(T instance) {
        List<T> results = (List<T>)getHibernateTemplate().findByExample(instance);
        return results;
    }    
    
    /**
     * ���ID���Ҷ���
     */
    public T findById(Serializable id) {
    	return (T) getHibernateTemplate().get(getPojoClassName(), id);
    }
    
    /**
     * ���ĳ���������Խ��в���
     */
    public List<T> findByProperty(String propertyName, Object value) {
       String queryString = "from " + getPojoClassName() + " as model where model." 
                               + propertyName + "= ?";
       return (List<T>)getHibernateTemplate().find(queryString, value);
    }
    
    /**
	 * �����Բ�ѯ�����������û���¼��֤��
	 * @param properties �����������
	 * @param values ��������ֵ
	 * @return
	 */
	public List<T> findByProperties(String[] properties, Object[] values){
		StringBuffer queryBuf = new StringBuffer();
		
		String pojoName = getPojoClassName();
		
		queryBuf.append("from ");
		queryBuf.append(getPojoClassName());
		queryBuf.append(" as model where ");
		
		StringBuffer whereBuf = new StringBuffer();
		
		for(String property : properties){
			whereBuf.append(" and ");
			whereBuf.append("model.");
			whereBuf.append(property);
			whereBuf.append("=?");
		}
		
		String whereStr = StringUtils.removeStart(whereBuf.toString(), " and");
		
		queryBuf.append(whereStr);
		
		return (List<T>) getHibernateTemplate().find(queryBuf.toString(), values);
	}
	
    //�½����޸ġ�ɾ��
    
    /**
     * �½�����ʵ��
     */
	public ID save(T entity) {
		getSession().save(entity);
		getHibernateTemplate().save(entity);
		getHibernateTemplate().flush();
        return (ID)getHibernateTemplate().save(entity);
    }
    
    /**
     * �����Ѵ��ڵĶ���
     */
    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }
    
    /**
     * ɾ��ָ��ID�Ķ���
     */
    public void delete(ID id) {
           T instance = findById(id);
           if (instance != null)
               getHibernateTemplate().delete(instance);
    }
    
    /**
     * ɾ��ָ������
     */
    public void delete(T persistentInstance) {
        getHibernateTemplate().delete(persistentInstance);
    }    
    
    //��ҳ
    /**
     * ���Criteria���ط�ҳ��ָ��ҳ��С����ʼλ��
     */
    public PaginationSupport findPageByCriteria(final Criteria criteria, final int pageSize, final int startIndex) {   
        int totalCount = getCountByCriteria(criteria);   
        criteria.setProjection(null);
        List items = criteria.setFirstResult(startIndex).setMaxResults(pageSize).list();
        items = transformResults(items);
        PaginationSupport ps = new PaginationSupport(items, totalCount, pageSize, startIndex);
        return ps;
    }
    
    /**
     * ���Criteria���ط�ҳ��Ĭ��ҳ��С���ӵ�0����ʼ
     */
    public PaginationSupport findPageByCriteria(final Criteria criteria) {   
        return findPageByCriteria(criteria, PaginationSupport.PAGESIZE, 0);   
    }   
 
    /**
     * ���Criteria���ط�ҳ��Ĭ��ҳ��С���ӵ�startIndex����ʼ
     */
    public PaginationSupport findPageByCriteria(final Criteria criteria, final int startIndex) {   
        return findPageByCriteria(criteria, PaginationSupport.PAGESIZE, startIndex);   
    }
    
    /**
     * ���Criteriaͳ������
     */
    public int getCountByCriteria(final Criteria criteria) {   
        Integer count = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();    
        return count.intValue();   
    }
    
    /**
     * ���DetachedCriteria���ط�ҳ��ָ��ҳ��С����ʼλ��
     */
    public PaginationSupport findPageByCriteria(final DetachedCriteria detachedCriteria, final int pageSize, final int startIndex) {   
        return (PaginationSupport) getHibernateTemplate().execute(new HibernateCallback() {   
            public Object doInHibernate(Session session) throws HibernateException {   
                Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();   
                criteria.setProjection(null);
                List items = criteria.setFirstResult(startIndex).setMaxResults(pageSize).list();
                items = transformResults(items);
                PaginationSupport ps = new PaginationSupport(items, totalCount, pageSize, startIndex);   
                return ps;   
            }
        });   
    }
    
    /**
     * ���DetachedCriteria���ط�ҳ��Ĭ��ҳ��С���ӵ�0����ʼ
     */
    public PaginationSupport findPageByCriteria(final DetachedCriteria detachedCriteria) {   
        return findPageByCriteria(detachedCriteria, PaginationSupport.PAGESIZE, 0);   
    }   
  
    /**
     * ���DetachedCriteria���ط�ҳ��Ĭ��ҳ��С���ӵ�startIndex����ʼ
     */
    public PaginationSupport findPageByCriteria(final DetachedCriteria detachedCriteria, final int startIndex) {   
        return findPageByCriteria(detachedCriteria, PaginationSupport.PAGESIZE, startIndex);   
    } 
    
    /**
     * ���DetachedCriteriaͳ������
     */
    public int getCountByCriteria(final DetachedCriteria detachedCriteria) {
        Integer count = (Integer) getHibernateTemplate().execute(new HibernateCallback() {   
            public Object doInHibernate(Session session) throws HibernateException {   
                Criteria criteria = detachedCriteria.getExecutableCriteria(session);   
                return criteria.setProjection(Projections.rowCount()).uniqueResult();   
            }   
        });   
        return count.intValue();   
    } 
    
    /**
     * ���hql���ط�ҳ��ָ��ҳ��С����ʼλ��
     */
    public PaginationSupport findPageByQuery(final String hql, final int pageSize, final int startIndex, Object...values) {
        int totalCount = getCountByQuery(hql, values);
        
        if (totalCount < 1)
            return new PaginationSupport(new ArrayList(0), 0);

        Query query = createQuery(hql, values);
        List items = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
        PaginationSupport ps = new PaginationSupport(items, totalCount, pageSize, startIndex);
        return ps;
    }
    
    /**
     * ���hql���ط�ҳ��Ĭ��ҳ��С���ӵ�0����ʼ
     */
    public PaginationSupport findPageByQuery(final String hql, Object...values) {   
        return findPageByQuery(hql, PaginationSupport.PAGESIZE, 0, values);   
    }   
 
    /**
     * ���hql���ط�ҳ��Ĭ��ҳ��С���ӵ�startIndex����ʼ
     */
    public PaginationSupport findPageByQuery(final String hql, final int startIndex, Object...values) {   
        return findPageByQuery(hql, PaginationSupport.PAGESIZE, startIndex, values);  
    }
    
    /**
     * ���hqlͳ������
     */
    public int getCountByQuery(final String hql, Object...values) {   
        String countQueryString = " select count (*) " + removeSelect(removeOrders(hql));
        List countlist = getHibernateTemplate().find(countQueryString, values);
        return (Integer) countlist.get(0);
    }
    
    //����Criteria��Query
    
    /**
     * ����Criteria����
     *
     * @param criterions �ɱ��Restrictions�����б�
     */
    public Criteria createCriteria(Criterion...criterions) {
        Criteria criteria = getSession().createCriteria(getPojoClass());
        for (Criterion c : criterions)
            criteria.add(c);
        return criteria;
    }

    /**
     * ����Criteria���󣬴������ֶ��������ֶ�
     */
    public Criteria createCriteria(String orderBy, boolean isAsc, Criterion...criterions) {
        Criteria criteria = createCriteria(criterions);
        if (isAsc)
            criteria.addOrder(Order.asc(orderBy));
        else
            criteria.addOrder(Order.desc(orderBy));
        return criteria;
    }
    
    /**
     * ����ȡ��SpringSide.
     * ����Query����. ������Ҫfirst,max,fetchsize,cache,cacheRegion��������õĺ���,�����ڷ���Query����������.
     * ���������������,���£�
     * <pre>
     * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
     * </pre>
     * ���÷�ʽ���£�
     * <pre>
     *        dao.createQuery(hql)
     *        dao.createQuery(hql,arg0);
     *        dao.createQuery(hql,arg0,arg1);
     *        dao.createQuery(hql,new Object[arg0,arg1,arg2])
     * </pre>
     *
     * @param values �ɱ����.
     */
    public Query createQuery(String hql, Object... values) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < values.length; i++) {
            query.setParameter(i, values[i]);
        }
        return query;
    }
    
    /**
     * ����ȡ��SpringSide.
     * ȥ��hql��select�Ӿ䣬δ����union�����
     */
    private static String removeSelect(String hql) {
        int beginPos = hql.toLowerCase().indexOf("from");
        return hql.substring(beginPos);
    }

    /**
     * ����ȡ��SpringSide.
     * ȥ��hql��orderby�Ӿ�
     */
    private static String removeOrders(String hql) {
        Pattern p = Pattern.compile("order/s*by[/w|/W|/s|/S]*", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(hql);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "");
        }
        m.appendTail(sb);
        return sb.toString();
    }
    
    /**
     * �����ϲ�ѯ�Ľ�����ݴ�Map����Object[]ת��Ϊʵ�����ͣ����û��ת����Ҫ��ֱ�ӷ���
     */
    private List transformResults(List items) {
        if (items.size() > 0) {
            if (items.get(0) instanceof Map) {
                ArrayList list = new ArrayList(items.size());
                for (int i = 0; i < items.size(); i++) {
                    Map map = (Map)items.get(i);
                    list.add(map.get(CriteriaSpecification.ROOT_ALIAS));
                }
                return list;
            } else if (items.get(0) instanceof Object[]) {
                ArrayList list = new ArrayList(items.size());
                int pos = 0;
                for (int i = 0; i < ((Object[])items.get(0)).length; i++) {
                    if (((Object[])items.get(0))[i].getClass() == getPojoClass()) {
                        pos = i;
                        break;
                    }
                }
                for (int i = 0; i < items.size(); i++) {
                    list.add(((Object[])items.get(i))[pos]);
                }
                return list;
            } else
                return items;
        } else
            return items;
    }
}
