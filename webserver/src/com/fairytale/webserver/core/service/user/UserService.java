package com.fairytale.webserver.core.service.user;

import org.json.JSONException;
import org.json.JSONObject;

import com.fairytale.webserver.core.entity.user.User;
/**
 * 
 * @author Liudishi
 * 2014��8��23��
 */
public interface UserService {

	/**
	 * �û�ע��
	 * @param user �û�ע����Ϣ
	 * @return �û�����
	 */
	public Long addUser(User user);
	
	/**
	 * ����û�����û�������Ϣ
	 * @param loginName �û���¼��ƣ������ǣ��û��������ַ���ֻ�������Ϣ
	 * @return ��������û�������Ϣ
	 */
	public User findUserByLoginName(String loginName);
	
	/**
	 * �û���¼��֤
	 * @param requestJson ���û�������ȣ��û�����������䣬�ֻ���룬�����Ǿ���MD5���ܵ��ַ�
	 * @return
	 */
	public JSONObject checkLogin(JSONObject requestJson) throws JSONException;
}
