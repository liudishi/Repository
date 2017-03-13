package com.fairytale.webserver.core.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fairytale.webserver.core.dao.user.UserDao;
import com.fairytale.webserver.core.entity.user.User;
import com.fairytale.webserver.core.service.user.UserService;
/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��24��
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao<User, Long> userDao;
	
	public void setUserDao(UserDao<User, Long> userDao) {
		this.userDao = userDao;
	}
	
	public UserDao<User, Long> getUserDao() {
		return userDao;
	}
	public Long addUser(User user) {
		return (Long) userDao.save(user);
	}
	
	public User findUserByLoginName(String loginName) {
		User user = null;
		List<User> users = new ArrayList<User>();
		
		users = userDao.findByProperty("username", loginName);
		
		if(users.size() < 1){
			users = userDao.findByProperty("email", loginName);
		}
		
		if(users.size() < 1){
			users = userDao.findByProperty("cellphone", loginName);
		}
		
		user = users.get(0);
		
		return user;
	}
	
	/**
	 * �û���¼��֤
	 * @param dataJson ���û�������ȣ��û�����������䣬�ֻ���룬�����Ǿ���MD5���ܵ��ַ�
	 * @return
	 * @throws JSONException 
	 */
	public JSONObject checkLogin(JSONObject dataJson) throws JSONException{
		JSONObject responseJson = new JSONObject();
		responseJson.put("data", dataJson);
		//���ڷ�װ�û���Ϣ
		JSONObject metadataJson = new JSONObject();
		
		//��ȡ�û�������ȵ�¼��֤��Ϣ
		String username = dataJson.getString("username");
		String password = dataJson.getString("password");
		
		List<User> users = new ArrayList<User>();
		
		String[] properties = new String[]{"email"};
		String[] values = new String[]{username};
		//����������
		users = userDao.findByProperties(properties, values);
		//������䲻���ڣ������ֻ�������
		if(users.size() < 1){
			properties = new String[]{"cellphone"};
			users = userDao.findByProperties(properties, values);
			//����ֻ���벻���ڣ�ֱ�ӷ���
			if(users.size() < 1){
				metadataJson.put("result", false);
				metadataJson.put("details", "�û������");
				responseJson.put("metadata", metadataJson);
				return responseJson;
			}else{
				//����ֻ�����¼����֤����
				properties = new String[]{"cellphone", "password"};
				values = new String[]{username, password};
				users = userDao.findByProperties(properties, values);
				//����������ֱ�ӷ���
				if(users.size() < 1){
					metadataJson.put("result", false);
					metadataJson.put("details", "�������");
					responseJson.put("metadata", metadataJson);
					return responseJson;
				}
			}
		}else{
			//��������¼����֤����
			properties = new String[]{"email", "password"};
			values = new String[]{username, password};
			users = userDao.findByProperties(properties, values);
			//����������ֱ�ӷ���
			if(users.size() < 1){
				metadataJson.put("result", false);
				metadataJson.put("details", "�������");
				responseJson.put("metadata", metadataJson);
				return responseJson;
			}
		}
		
		User user = users.get(0);
		
		dataJson.put("name", user.getName());
		dataJson.put("email", user.getEmail());
		dataJson.put("cellphone", user.getCellphone());
		dataJson.put("gender", user.getGender());
		dataJson.put("birthdate", user.getBirthdate());
		
		metadataJson.put("result", true);
		metadataJson.put("details", "��¼�ɹ�");
		
		responseJson.put("metadata", metadataJson);
		responseJson.put("data", dataJson);
		
		return responseJson;
	}
}
