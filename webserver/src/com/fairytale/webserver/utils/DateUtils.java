package com.fairytale.webserver.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

public class DateUtils {

	/**
	 * ����ָ���ĸ�ʽ�����������Ͷ���ת�����ַ����磺yyyy-MM-dd,yyyy/MM/dd,yyyy/MM/dd hh:mm:ss
	 * ����������Ϊnull,�򷵻ؿ�ֵ
	 * @param date �������Ͷ���
	 * @param format ��ת���ĸ�ʽ
	 * @return ���ڸ�ʽ�ַ�
	 */
	public static String formatDate(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat formater = new SimpleDateFormat(format);
		return formater.format(date);
	}
	
	/**
	 * ����ָ���ĸ�ʽ����������ת�����ַ����磺yyyy-MM-dd,yyyy/MM/dd,yyyy/MM/dd hh:mm:ss
	 * �����ĺ�����Ϊû��ֵ,�򷵻ؿ�ֵ
	 * @param milliseconds ������
	 * @param format ��ת���ĸ�ʽ
	 * @return ���ڸ�ʽ�ַ�
	 */
	public static String formatDate(long milliseconds, String format) {
		if (milliseconds <= 0L) {
			return "";
		}
		SimpleDateFormat formater = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliseconds);
		return formater.format(calendar.getTime());
	}

	/**
	 * ���������Ͷ���ת����yyyy-MM-dd�����ַ�
	 * ����������Ϊnull,�򷵻ؿ�ֵ
	 * @param date �������Ͷ���
	 * @return ���ڸ�ʽ�ַ�
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		return formater.format(date);
	}
	
	/**
	 * @author:luowei
	 * @createDate 2012-9-28
	 * @param date
	 * @return String
	 * @description
	 * ��ȡ��һ����
	 */
	public   static   String   getMonday(Date   date){ 
		  Calendar   c   =   Calendar.getInstance(); 
		  c.setTime(date); 
		  c.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY); 
		  return   new   SimpleDateFormat( "yyyy-MM-dd ").format(c.getTime()); 
    }
	
	/**
	 * ���������Ͷ���ת����yyyy-MM-dd HH:mm:ss�����ַ�
	 * ����������Ϊnull,�򷵻ؿ�ֵ
	 * @param date �������Ͷ���
	 * @return ���ڸ�ʽ�ַ�
	 */
	public static String formatTime(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formater.format(date);
	}

	/**
	 * ����ָ���ĸ�ʽ�����ַ�������������Ͷ������磺yyyy-MM-dd,yyyy/MM/dd,yyyy/MM/dd hh:mm:ss
	 * @param dateStr ���ڸ�ʽ���ַ�
	 * @param format �ַ�ĸ�ʽ
	 * @return �������Ͷ���
	 */
	public static Date parseDate(String dateStr, String format) {
		if (StringUtils.isEmpty(dateStr)) {
			return null;
		}
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			return formater.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����ָ���ĸ�ʽ�����ַ�������������Ͷ������磺yyyy-MM-dd,yyyy/MM/dd,yyyy/MM/dd hh:mm:ss
	 * @param milliseconds ������
	 * @param format �ַ�ĸ�ʽ
	 * @return �������Ͷ���
	 */
	public static Date parseDate(long milliseconds) {
		if (milliseconds <= 0L) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliseconds);
		return calendar.getTime();
	}

	/**
	 * ���ַ�yyyy-MM-dd������������
	 * @param dateStr ���ڸ�ʽ���ַ�
	 * @return �������Ͷ���
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd");
	}

	/**
	 * ��ȡ��ǰ���
	 * @return int
	 */
	public static int getYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	/**
	 * ��ȡ��ǰ�·�
	 * @return int
	 */
	public static int getMonth() {
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}

	/**
	 * �ж����������Ƿ�Ϊͬһ��
	 * @param date1 �������Ͷ���1
	 * @param date2 �������Ͷ���2
	 * @return true or false
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		if (formatDate(date1).equals(formatDate(date2))) {
			return true;
		}
		return false;
	}

	/**
	 * �ж����������Ƿ�Ϊͬһ��
	 * @param date1 �������Ͷ���1
	 * @param date2 �������Ͷ���2
	 * @return true or false
	 */
	public static boolean isSameMonth(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		if (formatDate(date1, "yyyy-MM").equals(formatDate(date2, "yyyy-MM"))) {
			return true;
		}
		return false;
	}

	/**
	 * �ж����������Ƿ�Ϊͬһ��
	 * @param date1 �������Ͷ���1
	 * @param date2 �������Ͷ���2
	 * @return true or false
	 */
	public static boolean isSameYear(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		if (formatDate(date1, "yyyy").equals(formatDate(date2, "yyyy"))) {
			return true;
		}
		return false;
	}

	/**
	 * ���ָ���ĸ�ʽ�����磺yyyy-MM-dd����ȡ�����ʱ���ַ�
	 * @return �����ַ�
	 */
	public static String getDate(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String strDate = sdf.format(date);
		return strDate;
	}


	/**
	 * ���ָ���ĸ�ʽ�����磺yyyy-MM-dd����ȡ�����ʱ���ַ�
	 * @return �����ַ�
	 */
	public static String getYesterday(String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String strDate = sdf.format(cal.getTime());
		return strDate;
	}

	

	/**
	 * ��ָ�����������ӻ����ָ��������
	 * @param date ��Ҫ�޸ĵ����ڶ���
	 * @param amount ��Ҫ�޸ĵ������������Ҫ����һ�죬amount=1,������һ�죬amount=-1;
	 * @return �޸ĺ��������Ͷ���
	 */
	public static Date addDay(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, amount);
		return cal.getTime();
	}

	/**
	 * ��ָ�����������ӻ����ָ��������
	 * @param date ��Ҫ�޸ĵ����ڶ���
	 * @param amount ��Ҫ�޸ĵ������������Ҫ����һ���£�amount=1,������һ���£�amount=-1;
	 * @return �޸ĺ��������Ͷ���
	 */
	public static Date addMonth(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, amount);
		return cal.getTime();
	}
	
	/**
	 * ��ָ�����������ӻ����ָ��������
	 * @param date ��Ҫ�޸ĵ����ڶ���
	 * @param amount ��Ҫ�޸ĵ������������Ҫ����һ�꣬amount=1,������һ�꣬amount=-1;
	 * @return �޸ĺ��������Ͷ���
	 */
	public static Date addYear(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, amount);
		return cal.getTime();
	}
	
	/**
	 * �����������������Сʱ��
	 * @param date1 ���ڶ���1
	 * @param date2 ���ڶ���2
	 * @return �������������Сʱ��
	 */
	public static double getHours(Date date1, Date date2) {
		if(date1==null||date2==null){
			return 0;
		}
		date2.setSeconds(0);
		date1.setSeconds(0);
		return (date2.getTime()-date1.getTime())*1.0/(1000*60*60);
	}
	
	/**
	 * �������������������(���Ե�����)
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static Integer getDays(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			return 0;
		}
		// �Ƚ�ʱ���ƶ�ȥ��
		Date start = DateUtils.parseDate(DateUtils.formatDate(startDate,
				"yyyy-MM-dd"));
		Date end = DateUtils.parseDate(DateUtils.formatDate(endDate,
				"yyyy-MM-dd"));
		Long intervalDays = (end.getTime() - start.getTime())
				/ (24 * 3600 * 1000);
		return intervalDays.intValue();
	}
	
	/**
	 * �������������������
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long getMinutes(Date startDate, Date endDate) {
		if(startDate==null||endDate==null){
			return 0;
		}
		startDate.setSeconds(0);
		endDate.setSeconds(0);
		return (endDate.getTime()-startDate.getTime())/(1000*60);
	}
	
	public static String formatMinutes(Integer minutes){
		String hh = "0";
		String mm = "0";
		Integer h = minutes/60;
		Integer m = minutes%60;
		hh=(hh+h).substring((hh+h).length()-2, (hh+h).length());
		mm=(mm+m).substring((mm+m).length()-2, (mm+m).length());
		return hh+":"+mm+":"+"00";
	}
	
	/**
	 * 
	 * @createDate 2011-1-21
	 * @author GuaBin
	 * @param date �ַ����͵�����
	 * @param days ���ӻ���ٵ�������1��-1
	 * @param format ���ڸ�ʽ
	 * @return String 
	 * @description
	 *  ���ַ����͵��������ӻ������������ַ���������
	 */
	public static String addDay(String date,int days,String format){
		Date temp = DateUtils.parseDate(date);
		temp = DateUtils.addDay(temp, days);
		return DateUtils.formatDate(temp,format);
	}
	
	/**
	 * 
	 * @createDate 2011-1-21
	 * @author GuaBin
	 * @param date �ַ����͵�����
	 * @param months ���ӻ���ٵ�������1��-1
	 * @param format ���ڸ�ʽ
	 * @return String
	 * @description
	 * ���ַ����͵��������ӻ������������ַ���������
	 */
	public static String addMonth(String date,int months,String format){
		Date temp = DateUtils.parseDate(date,format);
		temp = DateUtils.addMonth(temp, months);
		return DateUtils.formatDate(temp,format);
	}
	
	public static String addYear(String date,int years,String format){
		Date temp = DateUtils.parseDate(date,format);
		temp = DateUtils.addYear(temp, years);
		return DateUtils.formatDate(temp,format);
	}
	
	/**
	 * 
	 * @createDate 2011-1-21
	 * @author GuaBin
	 * @param date ����
	 * @param days ���ӻ���ٵ�������1��-1
	 * @param format ���ڸ�ʽ
	 * @return String
	 * @description
	 * ���������ӻ�����������format��ʽ�����ַ���������
	 */
	public static String addDay(Date date,int days,String format){
		Date temp = DateUtils.addDay(date, days);
		return DateUtils.formatDate(temp,format);
	}
	/**
	 * 
	 * @createDate 2011-1-21
	 * @author GuaBin
	 * @param date ����
	 * @param months ���ӻ���ٵ�������1��-1
	 * @param format ���ڸ�ʽ
	 * @return String
	 * @description
	 * ���������ӻ�����������format��ʽ�����ַ���������
	 */
	public static String addMonth(Date date,int months,String format){
		Date temp = DateUtils.addMonth(date, months);
		return DateUtils.formatDate(temp,format);
	}

	
	/**
	 * ��������ж������Ƿ���ĩ
	 * �������ĩ,�ͷ���"true"
	 * �������ĩ���ͷ���"false"
	 * @param date dateҪ�����ָ�ʽ��yyyy-MM-dd
	 * @return boolean
	 */
	public static  boolean isWeekend(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        //1������� 7�������
        if(dayOfWeek==1 || dayOfWeek==7){ 
        	return true;
        }else{
        	return false;
        }
	}
	
	/**
	 * �ж��������ڴ�С
	 * ���startDate ���ڵ��� endDate �ͷ���true
	 * ���startDate С�� endDate �ͷ���false
	 * @param startDate
	 * @param endDate
	 * @return boolean
	 */
	public static boolean judgeSize(Date startDate , Date endDate){
		if(startDate.getTime() > endDate.getTime()){
			return true;
		}else if(startDate.getTime() == endDate.getTime()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * �ж��������ڴ�С
	 * ���startDate ���� endDate �ͷ���true
	 * ���startDate С�� ����endDate �ͷ���false
	 * @param startDate
	 * @param endDate
	 * @return boolean
	 */
	public static boolean judgeDateSize(Date startDate , Date endDate){
		if(startDate.getTime() > endDate.getTime()){
			return true;
		}else if(startDate.getTime() == endDate.getTime()){
			return false;
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * @createDate 2011-5-31
	 * @author GuaBin
	 * @param date
	 * @return String
	 * @description
	 * ������ת��������
	 */
	public static String dayOfWeek(String date){
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtils.parseDate(date));
		int day = c.get(Calendar.DAY_OF_WEEK);
		if(1 == day)
			return "������";
		if(2 == day)
			return "����һ";
		if(3 == day)
			return "���ڶ�";
		if(4 == day)
			return "������";
		if(5 == day)
			return "������";
		if(6 == day)
			return "������";
		if(7 == day)
			return "������";
		return "";
	}
	/**
	 * 
	 * @createDate 2011-5-31
	 * @author GuaBin
	 * @param date
	 * @return String
	 * @description
	 * ������ת��������
	 */
	public static String dayOfWeek(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DAY_OF_WEEK);
		if(1 == day)
			return "������";
		if(2 == day)
			return "����һ";
		if(3 == day)
			return "���ڶ�";
		if(4 == day)
			return "������";
		if(5 == day)
			return "������";
		if(6 == day)
			return "������";
		if(7 == day)
			return "������";
		return "";
	}

	
	/**
	 * @description		�ж�ĳ���ڣ�ʱ�䣩�Ƿ��ڲ�����ָ�����ڣ�ʱ�䣩�η�Χ֮�ڣ�������ʼʱ��ͽ���ʱ��
	 * @param date
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean judgeBetween(Date date, Date startDate, Date endDate){
		if(date == null || startDate == null || endDate == null){
			return false;
		}
		long msOfDate = date.getTime();
		long msOfStartDate = startDate.getTime();
		long msOfEndDate = endDate.getTime();
		if(msOfDate >= msOfStartDate && msOfDate <= msOfEndDate){
			return true;
		}
		return false;
	}
	
	/**
	 * @description		�ж�ĳ���ڣ�ʱ�䣩�Ƿ��ڲ�����ָ�����ڣ�ʱ�䣩�η�Χ֮�ڣ���������ʼʱ��ͽ���ʱ��
	 * @param date
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean judgeStrictBetween(Date date, Date startDate, Date endDate){
		if(date == null || startDate == null || endDate == null){
			return false;
		}
		long msOfDate = date.getTime();
		long msOfStartDate = startDate.getTime();
		long msOfEndDate = endDate.getTime();
		if(msOfDate > msOfStartDate && msOfDate < msOfEndDate){
			return true;
		}
		return false;
	}
	
	/**
	 * @description		����ʱ�����ĺ���ֵ������ֵΪ����˵����һ������ָ����ʱ�����ڵڶ�������ָ����ʱ��
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long getIntervalOfLong(Date startDate, Date endDate){
		Calendar calendarOfStartDate = Calendar.getInstance();
		calendarOfStartDate.setTime(startDate);
		Calendar calendarOfEndDate = Calendar.getInstance();
		calendarOfEndDate.setTime(endDate);
		return calendarOfEndDate.getTimeInMillis() - calendarOfStartDate.getTimeInMillis();
	}
	
	/**
	 * @description		��ȡĳ��ĳ��ĳ�������ʱ�䣬��00:00:00
	 * @param date
	 * @return
	 */
	public static Date getEarliestDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * @description		��ȡĳ��ĳ��ĳ�������ʱ�䣬��23:59:59
	 * @param date
	 * @return
	 */
	public static Date getLastestDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * @description		��ȡ�����µ����һ��
	 * @param date
	 * @return
	 */
	public static Date getLastestDayOfCurrentMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return calendar.getTime();
	}
	
	/**
	 * ��ȡ�������µ����һ�죬�������
	 * @param year
	 * @param month				��ʵ���·ݣ���1�¿�ʼ
	 * @return
	 */
	public static int getLastestDayOfMonth(int year, int month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int get(int field, Date date){
		if(date == null){
			return 0;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(field);
		
	}
	
	public static Date set(int field, int value, Date date){
		if(date == null){
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(field, value);
		return calendar.getTime();
		
	}
	
	public static int getQuarter(Date date) {
		if(date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH)/3+1;
	}
	
	public static int getNextQuater(Date date) {
		if(getQuarter(date) == 4) {
			return 1;
		}
		return getQuarter(date) +1;
	}
	
	public static int getLastQuater(Date date) {
		if(getQuarter(date) == 1) {
			return 4;
		}
		return getQuarter(date) -1;
	}
	
	public static String getQuarterCN(Date date) {
		int quarter = getQuarter(date);
		if(quarter == 1) 
			return "һ";
		if(quarter == 2)
			return "��";
		if(quarter == 3)
			return "��";
		if(quarter == 4)
			return "��";
		return null;
	}
	
	public static String getNextQuarterCN(Date date) {
		int quarter = getQuarter(date);
		if(quarter == 1) 
			return "��";
		if(quarter == 2)
			return "��";
		if(quarter == 3)
			return "��";
		if(quarter == 4)
			return "һ";
		return null;
	}
}
