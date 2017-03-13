package com.fairytale.webserver.utils;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.fairytale.webserver.core.entity.user.User;

/**
 * @author Liudishi
 * 2014��8��24��
 */
public class SpringSecurityUtils {

	/** 
	  * ȡ�õ�ǰ�û�, ����ֵΪUserInfo���������, ���ǰ�û�δ��¼�򷵻�null. 
	  */  
	 @SuppressWarnings("unchecked")  
	 public static <T extends User> T getCurrentUser() {  
	  Authentication authentication = getAuthentication();  
	  
	  if (authentication == null) {  
	   return null;  
	  }  
	  
	  Object principal = authentication.getPrincipal();  
	  if (!(principal instanceof User)) {  
	   return null;  
	  }  
	  
	  return (T) principal;  
	 }  
	  
	 /** 
	  * ȡ�õ�ǰ�û��ĵ�¼��, ���ǰ�û�δ��¼�򷵻ؿ��ַ�. 
	  */  
	 public static String getCurrentUserName() {  
	  Authentication authentication = getAuthentication();  
	  
	  if (authentication == null || authentication.getPrincipal() == null) {  
	   return "";  
	  }  
	  
	  return authentication.getName();  
	 }  
	   
	 /** 
	  * ȡ�õ�ǰ�û�����ʵ����, ���ǰ�û�δ��¼�򷵻ؿ��ַ�. 
	  */  
	 public static String getCurrentName() {  
	  return getCurrentUser().getName();  
	 }  
	  
	 /** 
	  * ȡ�õ�ǰ�û���¼IP, ���ǰ�û�δ��¼�򷵻ؿ��ַ�. 
	  */  
	 public static String getCurrentUserIp() {  
	  Authentication authentication = getAuthentication();  
	  
	  if (authentication == null) {  
	   return "";  
	  }  
	  
	  Object details = authentication.getDetails();  
	  if (!(details instanceof WebAuthenticationDetails)) {  
	   return "";  
	  }  
	  
	  WebAuthenticationDetails webDetails = (WebAuthenticationDetails) details;  
	  return webDetails.getRemoteAddress();  
	 }  
	  
	 /** 
	  * �ж��û��Ƿ�ӵ�н�ɫ, ����û�ӵ�в����е�����һ����ɫ�򷵻�true. 
	  */  
	 public static boolean hasAnyRole(String... roles) {  
	  Authentication authentication = getAuthentication();  
	  
	  if (authentication == null) {  
	   return false;  
	  }  
	  
	  Collection<GrantedAuthority> grantedAuthorityList = (Collection<GrantedAuthority>) authentication.getAuthorities();
	  for (String role : roles) {  
	   for (GrantedAuthority authority : grantedAuthorityList) {  
	    if (role.equals(authority.getAuthority())) {  
	     return true;  
	    }  
	   }  
	  }  
	  
	  return false;  
	 }  
	  
	 /** 
	  * ��UserDetails���浽Security Context. 
	  * 
	  * @param userDetails 
	  *            �ѳ�ʼ���õ��û���Ϣ. 
	  * @param request 
	  *            ���ڻ�ȡ�û�IP��ַ��Ϣ,��ΪNull. 
	  */  
	 public static void saveUserDetailsToContext(UserDetails userDetails,  
	   HttpServletRequest request) {  
	  PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(  
	    userDetails, userDetails.getPassword(), userDetails  
	      .getAuthorities());  
	  
	  if (request != null) {  
	   authentication.setDetails(new WebAuthenticationDetails(request));  
	  }  
	  
	  SecurityContextHolder.getContext().setAuthentication(authentication);  
	 }  
	  
	 /** 
	  * ȡ��Authentication, �統ǰSecurityContextΪ��ʱ����null. 
	  */  
	 private static Authentication getAuthentication() {  
	  SecurityContext context = SecurityContextHolder.getContext();  
	  
	  if (context == null) {  
	   return null;  
	  }  
	  
	  return context.getAuthentication();  
	 }  
}
