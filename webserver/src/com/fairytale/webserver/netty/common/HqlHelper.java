package com.fairytale.webserver.netty.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fairytale.webserver.netty.common.Page;

/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��28��
 */
public class HqlHelper {

	Logger logger = LoggerFactory.getLogger(HqlHelper.class);
	
	private String entityName;

	private String alias="a";//Ĭ�ϱ�����a
	private List<Object> params=new ArrayList<Object>();//��Ų�ѯ����ֵ
	private StringBuffer whereCondition=new StringBuffer("");
	private StringBuffer orderBy=new StringBuffer("");
	private Page queryPage;//��ҳ��ѯ����
	
	public HqlHelper(){
		
	}
	public HqlHelper(Class clazz){
		this.entityName=clazz.getSimpleName();
	}
	/**
	 * ��ӵ��ڱȽ�����
	 * @param property ʵ����������
	 * @param value  Double,String,Integer,Long,Float
	 * @return
	 */
	public HqlHelper addEqual(String property,Object value){
		
		if(StringUtils.isEmpty(property)||value==null||StringUtils.isEmpty(value.toString())){
			return this;
		}
		
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		params.add(value);
		whereCondition.append(alias+"."+property+" =?");
		return this;
	}
	
	/**
	 * ��ӵ��ڱȽ�����,�������Сд
	 * @param property ʵ����������
	 * @param value Double,String,Integer,Long,Float
	 * @return
	 */
	public HqlHelper addEqualIgnoreCase(String property,Object value){
		
		if(StringUtils.isEmpty(property)||value==null||StringUtils.isEmpty(value.toString())){
			return this;
		}
		
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		params.add(value.toString().trim().toUpperCase());
		whereCondition.append("upper("+alias+"."+property+") =?");
		return this;
	}
	
	/**
	 * ��Ӳ����ڱȽ�����
	 * @param property ʵ����������
	 * @param value  Double,String,Integer,Long,Float
	 * @return
	 */
	public HqlHelper addNotEqual(String property,Object value){
		
		if(StringUtils.isEmpty(property)||value==null||StringUtils.isEmpty(value.toString())){
			return this;
		}
		
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		
		params.add(value);
		whereCondition.append(alias+"."+property+" !=? ");
		
		return this;
	}
	
	/**
	 * ��Ӳ����ڱȽ�����,�������Сд
	 * @param property ʵ����������
	 * @param value Double,String,Integer,Long,Float
	 * @return
	 */
	public HqlHelper addNotEqualIgnoreCase(String property,Object value){
		
		if(StringUtils.isEmpty(property)||value==null||StringUtils.isEmpty(value.toString())){
			return this;
		}
		
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		params.add(value.toString().trim().toUpperCase());
		whereCondition.append(alias+"."+property+" !=? ");
		whereCondition.append("upper("+alias+"."+property+") != ?");
		return this;
	}
	
	/**
	 * ���LIKEģ���ѯ
	 * @param property ʵ����������
	 * @param value String
	 * @return
	 */
	public HqlHelper addLike(String property,String value){
		if(StringUtils.isEmpty(property)||value==null||StringUtils.isEmpty(value.toString())){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		params.add("%"+value+"%");
		whereCondition.append(alias+"."+property+" like ? ");
		return this;
	}
	
	/**
	 * ���LIKEģ���ѯ
	 * @param property ʵ����������
	 * @param value String
	 * @return
	 */
	public HqlHelper addRightLike(String property,String value){
		if(StringUtils.isEmpty(property)||value==null||StringUtils.isEmpty(value.toString())){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		params.add(value+"%");
		whereCondition.append(alias+"."+property+" like ? ");
		return this;
	}
	
	/**
	 * ���LIKEģ���ѯ,����ִ�Сд
	 * @param property ʵ����������
	 * @param value String
	 * @return
	 */
	public HqlHelper addLikeIgnoreCase(String property,String value){
		if(StringUtils.isEmpty(property)||value==null||StringUtils.isEmpty(value.toString())){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		params.add("%"+value.trim().toUpperCase()+"%");
		whereCondition.append("upper("+alias+"."+property+") like ?");
		return this;
	}
	
	
	
	/**
	 * �����ָ���ַ��β��ģ���ѯ,����ִ�Сд
	 * @param property ʵ����������
	 * @param value String
	 * @return
	 */
	public HqlHelper addEndWith(String property,String value){
		if(StringUtils.isEmpty(property)||value==null||StringUtils.isEmpty(value.toString())){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		params.add("%"+value.trim().toUpperCase());
		whereCondition.append(alias+"."+property+" like ?");
		return this;
	}
	
	/**
	 * �����ָ���ַ�ʼ��ģ���ѯ,����ִ�Сд
	 * @param property ʵ����������
	 * @param value String
	 * @return
	 */
	public HqlHelper addStartWith(String property,String value){
		if(StringUtils.isEmpty(property)||value==null||StringUtils.isEmpty(value.toString())){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		params.add(value.trim().toUpperCase()+"%");
		whereCondition.append(alias+"."+property+" like ?");
		return this;
	}
	
	/**
	 * ���IN��ѯ 
	 * @param property ʵ��������
	 * @param List ����
	 * @return
	 */
	public HqlHelper addIn(String property,List list){
		if(list==null||list.size()==0){
			return this;
		}
		return addIn(property,list.toArray());
	}
	
	
	/**
	 * ���IN��ѯ 
	 * @param property ʵ��������
	 * @param List ����
	 * @return
	 */
	public HqlHelper addNotIn(String property,List list){
		if(list==null||list.size()==0){
			return this;
		}
		return addNotIn(property,list.toArray());
	}
	
	/**
	 * ���IN��ѯ  
	 * @param property ʵ��������
	 * @param Object[] ��������
	 * @return
	 */
	public HqlHelper addIn(String property,Object[] array){
		if(array==null||array.length==0){
			return this;
		}
		StringBuffer sb=new StringBuffer("");
		for (int i = 0; i < array.length; i++) {
			Object obj = array[i];
			if(obj==null||"".equals(obj.toString().trim()) ){
				continue;
			}
			if(!"".equals(sb.toString().trim())){
				sb.append(",");
			}
			if(obj instanceof String){
				params.add(obj.toString().trim());
			}else{
				params.add(obj);
			}
			
			sb.append("?");
		}
		if("".equals(sb.toString())){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		List<String> inList=new ArrayList<String>();
		String sbString=sb.toString();//sbString��","��"��"��ɡ�
		if(sbString.length()>1800){//����ʺų���900����Ҳ����IN������900��������
			int i=0;
			while(true){
				if((i+1800)>=(sbString.length()-1)){
					String in=sbString.substring(i, sbString.length());
					inList.add(in);
					break;
				}else{
					String in=sbString.substring(i, i+1800);
					i=i+1800;
					inList.add(in);
				}
			}
		}else{
			inList.add(sbString);
		}
		
		StringBuffer childOr=new StringBuffer("");
		
		for (String in : inList) {
			if(!childOr.toString().equals("")){
				childOr.append(" or ");
			}
			if(in.startsWith(",")){
				in=in.substring(1);
			}
			if(in.endsWith(",")){
				in=in.substring(0,in.length()-1);
			}
			childOr.append(alias+"."+property+" in ("+in+")");
		}
		whereCondition.append("( "+childOr.toString()+" )");
		return this;
	}
	
	/**
	 * ���NOT IN��ѯ  
	 * @param property ʵ��������
	 * @param Object[] ��������
	 * @return
	 */
	public HqlHelper addNotIn(String property,Object[] array){
		if(array==null||array.length==0){
			return this;
		}
		StringBuffer sb=new StringBuffer("");
		for (int i = 0; i < array.length; i++) {
			Object obj = array[i];
			if(obj==null||"".equals(obj.toString().trim()) ){
				continue;
			}
			if(!"".equals(sb.toString().trim())){
				sb.append(",");
			}
			params.add(obj);
			sb.append("?");
		}
		if("".equals(sb.toString())){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		whereCondition.append(alias+"."+property+" not in ("+sb.toString()+")");
		
		return this;
	}
	
	/**
	 * ���IS NULL��ѯ
	 * @param property
	 * @return
	 */
	public HqlHelper addIsNull(String property){
		if(StringUtils.isBlank(property)){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		
		whereCondition.append(alias+"."+property+" is null ");
		return this;
	}
	
	/**
	 * ���IS NOT NULL��ѯ
	 * @param property
	 * @return
	 */
	public HqlHelper addIsNotNull(String property){
		if(StringUtils.isBlank(property)){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		
		whereCondition.append(alias+"."+property+" is not null ");
		return this;
	}
	
	/**
	 * ���С�ڲ�ѯ����
	 * @param property
	 * @return
	 */
	public HqlHelper addLessThan(String property,Object value){
		if(value==null||StringUtils.isEmpty(property)||StringUtils.isEmpty(value.toString())){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		
		params.add(value);
		whereCondition.append(alias+"."+property+" < ?");
		return this;
	}
	
	/**
	 * ���С�ڵ��ڲ�ѯ����
	 * @param property
	 * @return
	 */
	public HqlHelper addLessEqualThan(String property,Object value){
		if(value==null||StringUtils.isEmpty(property)||StringUtils.isEmpty(value.toString())){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		params.add(value);
		whereCondition.append(alias+"."+property+" <= ?");
		
		return this;
	}
	
	/**
	 * ��Ӵ��ڲ�ѯ����
	 * @param property
	 * @return
	 */
	public HqlHelper addGreatThan(String property,Object value){
		if(value==null||StringUtils.isEmpty(property)||StringUtils.isEmpty(value.toString())){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		params.add(value);
		whereCondition.append(alias+"."+property+" >?");
		
		return this;
	}

	
	/**
	 * ��Ӵ��ڵ��ڲ�ѯ����
	 * @param property
	 * @return
	 */
	public HqlHelper addGreatEqualThan(String property,Object value){
		if(value==null||StringUtils.isEmpty(property)||StringUtils.isEmpty(value.toString())){
			return this;
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		params.add(value);
		whereCondition.append(alias+"."+property+" >=?");
		return this;
	}
	
	/**
	 * ������ڷ�Χ��ѯ��yyyy-MM-dd��
	 * @param property ʵ��������
	 * @param fromDate ��ʼ����
	 * @param toDate ��������
	 * @return
	 */
	public HqlHelper addDateBetween(String property,String fromDate,String toDate){
		return addDateBetween(property,fromDate,toDate,"yyyy-MM-dd");
	}
	
	/**
	 * 
	 * @createDate 2011-4-18
	 * @author GuaBin
	 * @param startDateProperty ��ʼʱ������
	 * @param endDateProperty   ����ʱ������
	 * @param paramDate         ʱ�����
	 * @param formater          ʱ���ʽ
	 * @return HqlHelper
	 * @description
	 *
	 */
	public HqlHelper addDatePropertyBetween(String startDateProperty,String endDateProperty,String paramDate,String formater){
		
		if(StringUtils.isEmpty(paramDate)){
			return this;
		}
		
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		whereCondition.append(alias+"."+startDateProperty+" <= to_date('"+paramDate+"','"+formater+"') and ");
		whereCondition.append(alias+"."+endDateProperty+" >= to_date('"+paramDate+"','"+formater+"') ");
		
		return this;
	}
	
	
	/**
	 * ������ڷ�Χ��ѯ
	 * @param property ʵ��������
	 * @param fromDate ��ʼ����
	 * @param toDate ��������
	 * @param formater ��������ģʽ�����磺yyyy-MM��ʾֻ�Ƚϵ��·ݣ�yyyy-MM-dd�Ƚϵ������һ�죬�Դ�����
	 * @return
	 */
	public HqlHelper addDateBetween(String property,String fromDate,String toDate,String formater){
		
		if(StringUtils.isEmpty(fromDate) && StringUtils.isEmpty(toDate)){
			return this;
		}
		
		if(StringUtils.isNotBlank(fromDate)){
			if(!"".equals(whereCondition.toString())){
				whereCondition.append(" and ");
			}
			params.add(fromDate);
			whereCondition.append(alias+"."+property+">=to_date(?,'"+formater+"')");
		}
		if(StringUtils.isNotBlank(toDate)){
			if(!"".equals(whereCondition.toString())){
				whereCondition.append(" and ");
			}
			params.add(toDate);
			whereCondition.append(alias+"."+property+"<=to_date(?,'"+formater+"')");
		}
		return this;
	}
	
	/**
	 * ������ڷ�Χ��ѯ
	 * @param property ʵ��������
	 * @param fromDate ��ʼ����
	 * @param toDate ��������
	 * @param formater ��������ģʽ�����磺yyyy-MM��ʾֻ�Ƚϵ��·ݣ�yyyy-MM-dd�Ƚϵ������һ�죬�Դ�����
	 * @return
	 */
	public HqlHelper addBetween(String property,Integer from,Integer to){
		
		if(from==null&&to==null){
			return this;
		}
		
		if(from!=null){
			if(!"".equals(whereCondition.toString())){
				whereCondition.append(" and ");
			}
			params.add(from);
			whereCondition.append(alias+"."+property+">=?");
		}
		if(to!=null){
			if(!"".equals(whereCondition.toString())){
				whereCondition.append(" and ");
			}
			params.add(to);
			whereCondition.append(alias+"."+property+"<=?");
		}
		return this;
	}
	
	/**
	 * ��ӻ�������ѯ
	 * @param child
	 * @return
	 */
	public HqlHelper addOr(HqlHelper or){
		if(!"".equals(or.getWhereCondition().toString())){
			if(!"".equals(whereCondition.toString())){
				whereCondition.append(" and ");
			}
			params.addAll(or.getParams());
			whereCondition.append("("+or.getWhereCondition().toString().replace(" and ", " or ")+")");
		}
		return this;
	}
	
	/**
	 * OR��ѯ
	 * @param or
	 * @return
	 */
	public HqlHelper addArrayOR(HqlHelper ... or){
		StringBuffer sb=new StringBuffer("");
		for (HqlHelper hqlHelper : or) {
			if (StringUtils.isEmpty(hqlHelper.getWhereCondition().toString())) {
				continue;
			}
			if(!sb.toString().equals("")){
				sb.append(" or ");
			}
			params.addAll(hqlHelper.getParams());
			sb.append("("+hqlHelper.getWhereCondition().toString()+")");
		}
		if(!"".equals(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		whereCondition.append("("+sb.toString()+")");
		return this;
	}
	
	/**
	 * ��������ֶ�
	 * @param property ʵ��������
	 * @param type ����ʽ asc desc
	 * @return
	 */
	public HqlHelper addOrderBy(String property,String type){
		if(StringUtils.isNotBlank(property)&&StringUtils.isNotBlank(type)){
			if(orderBy.toString().indexOf(" order by")!=-1){
				orderBy.append(","+alias+"."+property+" "+type);
			}else{
				orderBy.append(" order by "+alias+"."+property+" "+type);
			}
			
		}
		return this;
	}
	
	/**
	 * ���HQL��ѯ���
	 * @return
	 */
	public String getHQL(){
		String hql=" from "+this.entityName+" "+this.alias;
		if(!"".equals(whereCondition.toString())){
			hql+=" where "+whereCondition.toString();
		}
		
		return hql+" "+orderBy.toString();
	}

	public StringBuffer getWhereCondition() {
		return whereCondition;
	}
	
	
	public List<Object> getParams() {
		return params;
	}
	public void setParams(List<Object> params) {
		this.params = params;
	}
	public Page getQueryPage() {
		return queryPage;
	}
	public void setQueryPage(Page queryPage) {
		this.queryPage = queryPage;
		if(queryPage!=null&&queryPage.getSort()!=null&&queryPage.getOrder()!=null){
			orderBy=new StringBuffer(" order by a."+queryPage.getSort()+" "+queryPage.getOrder());
		}
	}
	
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public HqlHelper addEqualWithLengthFunction(String property, Long length) {

		if(isBlankOrEmpty(property) || length == null || length < 1L){
			return this;
		}
		
		if(isNotBlankAndEmpty(whereCondition.toString())){
			whereCondition.append(" and ");
		}
		params.add(length);
		whereCondition.append(" length(").append(alias+"."+property+") =?");
		return this;
	}
	
	public boolean isNotBlankAndEmpty(String... strs){
		if(null == strs)
			return false;
		for(String str :strs){
			if(StringUtils.isBlank(str)
					|| StringUtils.isEmpty(str)){
				return false;
			}
		}
		return true;
	}
	
	public boolean isBlankOrEmpty(String... strs){
		if(null == strs)
			return true;
		for(String str :strs){
			if(StringUtils.isNotBlank(str)
					&& StringUtils.isNotEmpty(str)){
				return false;
			}
		}
		return true;
	}
}
