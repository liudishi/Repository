package com.fairytale.webserver.core.service.user.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Sets;
import com.fairytale.webserver.core.entity.user.Authority;
import com.fairytale.webserver.core.entity.user.Role;
import com.fairytale.webserver.core.entity.user.User;
import com.fairytale.webserver.core.service.user.UserService;

/**
 * @author Liudishi
 * 2014��8��24��
 */
@SuppressWarnings("deprecation")
@Transactional(readOnly=true)
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Resource
	private UserService userService;  
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;  
	}
	/** 
	 * ��ȡUserDetails��Ϣ�Ļص�����. 
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		User user = userService.findUserByLoginName(username);
	    if (user == null) {  
	    throw new UsernameNotFoundException("�û�" + username + " ������");  
	    } 
	  
	  Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities(user);  
	  // -- mini-webʾ��������������, ��ʱȫ����Ϊtrue. --//  
	  boolean enabled = true;  
	  boolean accountNonExpired = true;  
	  boolean credentialsNonExpired = true;  
	  boolean accountNonLocked = true;  
	  
	  User userdetails = new User(user.getPassword(), user.getName(),  
	    user.getEmail(), user.getUsername(), grantedAuths,  
	    accountNonExpired, accountNonLocked, credentialsNonExpired,  
	    enabled);  
	  
	  return userdetails;  
	}
	/** 
	 * ����û����н�ɫ��Ȩ�޼���. 
	 */
	private Set<GrantedAuthority> obtainGrantedAuthorities(User user) {
		Set<GrantedAuthority> authSet = Sets.newHashSet();
		for(Role role : user.getRoleList()) {
			for(Authority authority : role.getAuthorityList()) {
				authSet.add(new GrantedAuthorityImpl(authority.getPrefixedName()));
			}
		}
		return authSet;
	}

}
