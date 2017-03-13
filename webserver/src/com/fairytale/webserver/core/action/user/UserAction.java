package com.fairytale.webserver.core.action.user;

import java.sql.Date;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;

import com.fairytale.webserver.core.action.ActionSupport;
import com.fairytale.webserver.core.action.FtpRequest;
import com.fairytale.webserver.core.entity.user.User;
import com.fairytale.webserver.core.service.user.UserService;
import com.fairytale.webserver.utils.DateUtils;

import javax.annotation.Resource;
/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2016年7月7日
 */
@Controller("userAction")
public class UserAction extends ActionSupport {

	@Resource
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 用户登录
	 * @param requestJson 包含用户名，密码等，用户名可以是邮箱，手机号码，密码是经过MD5加密的字符串
	 * @return
	 * @throws JSONException 
	 */
	public JSONObject doLogin() throws JSONException{
		JSONObject requestJson = getFtpRequest().getRequestJson();
		JSONObject responseJson = this.userService.checkLogin(requestJson.getJSONObject("data"));
		
		JSONObject metadataJson = responseJson.getJSONObject("metadata");
		JSONObject dataJson = responseJson.getJSONObject("data");
		
		boolean result = metadataJson.getBoolean("result"); 
		
		//如果登录成功
		if(result){
			
			String email = dataJson.getString("email");
			String cellphone = dataJson.getString("cellphone");
			String gender = dataJson.getString("gender");
			java.sql.Date birthdate = (java.sql.Date) dataJson.get("birthdate");
			
		}
		requestJson.put("metadata", metadataJson);
		requestJson.put("data", dataJson);
		//把登录的结果信息返回客户端
		return requestJson;
	}
	
	/**
	 * �û�ע��
	 * @return 建议返回一个空JSONObject以防止客户端读取结果时出现空引用异常
	 * @throws JSONException 
	 */
	public JSONObject doLogout() throws JSONException{
		FtpRequest ftpRequest = this.getFtpRequest();
		JSONObject requestJson = ftpRequest.getRequestJson();
		JSONObject executionJson = requestJson.getJSONObject("execution");
		executionJson.put("logout", "ע��ɹ�");
		
		return requestJson;
	}
	
	/**
	 * 用户注册
	 * 操作结果分两种情况，一种是注册失败，原样返回用户提交的注册信息，另一种是注册成功，返回部分用户信息，密码等信息无须返回
	 * @param requestJson 包含操作数据，元数据，普通数据等信息
	 * @return 向客户端返回嵌套的JSONObject数据类型的对象，其中包含3个嵌套JSONObject，分别包含操作数据，元数据，普通数据等
	 * @throws JSONException 
	 */
	public JSONObject doRegister(Object... objects) throws JSONException{
		
		JSONObject requestJson = (JSONObject) objects[1];
		JSONObject responseJson = new JSONObject();
		JSONObject executionJson = requestJson.getJSONObject("execution");
		JSONObject metadataJson = requestJson.getJSONObject("metadata");
		JSONObject dataJson = requestJson.getJSONObject("data");
		//提取用户注册信息
		User user = new User();
//		user.setUsername(dataJson.getString("username"));
		
		//验证两次输入的密码是否一致
		String password = dataJson.getString("password");
		String repassword = dataJson.getString("repassword");
		
		if( ! StringUtils.isNotEmpty(password)
				|| ! password.equalsIgnoreCase(repassword)){
			//两次输入的密码不一致，或密码为空
			metadataJson.put("result", false);
			metadataJson.put("details", "������������벻һ��");
			
			responseJson.put("execution", executionJson);
			responseJson.put("metadata", metadataJson);
			responseJson.put("data", dataJson);
			
			return responseJson;
		}
		
		
		user.setPassword(password);
		user.setPassword(repassword);
		user.setEmail(dataJson.getString("email"));
		user.setCellphone(dataJson.getString("cellphone"));
//		user.setName(dataJson.getString("name"));
		user.setGender(dataJson.getString("gender"));
		user.setBirthdate(new Date(DateUtils.parseDate(dataJson.getString("birthdate")).getTime()));
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new Date(utilDate.getTime());
		user.setCreateDate(sqlDate);//注册日期
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		String gender = user.getGender();
		if("��".equalsIgnoreCase(gender)){
			user.setGender("1");
		}else if("Ů".equalsIgnoreCase(gender)){
			user.setGender("0");
		}
		//注册操作
		Long userId = userService.addUser(user);
		//如果为空，则说明注册操作失败，原样返回用户提交的注册信息，设置操作结果标志，并说明操作失败的原因
		if(userId == null){
			//元数据
			metadataJson.put("result", false);
			metadataJson.put("details", "ע��ʧ��");
			//普通数据
			dataJson.put("userId", userId);
			
			responseJson.put("execution", executionJson);
			responseJson.put("metadata", metadataJson);
			responseJson.put("data", dataJson);
			
			return responseJson;
		}
		//注册成功，设置操作结果标志，结果说明，以及部分用户信息等
		metadataJson.put("result", true);
		metadataJson.put("details", "ע��ɹ�");
		
		dataJson.put("userId", userId);
		
		responseJson.put("execution", executionJson);
		responseJson.put("metadata", metadataJson);
		responseJson.put("data", dataJson);
		//返回嵌套的JSONObject数据
		return responseJson;
	}
}
