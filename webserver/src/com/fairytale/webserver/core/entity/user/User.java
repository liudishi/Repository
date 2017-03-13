package com.fairytale.webserver.core.entity.user;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;
/**
 * �û���Ϣ
 * @author Liudishi
 * 2014��8��24��
 */
@Entity
@Table(name="T_USER_USER")
public class User implements UserDetails, CredentialsContainer, Serializable {

	/**
	 * �汾���
	 */
	private static final long serialVersionUID = -5746824795519945624L;
	
	public User(){

	}
	
	public User(
			String password, 
			String name, 
			String email,  
			final String username,  
			final Collection<? extends GrantedAuthority> authorities,  
			final boolean accountNonExpired, 
			final boolean accountNonLocked,  
			final boolean credentialsNonExpired, 
			final boolean enabled){
		
	}
	//�û�ID
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	//������
	@Column(name="NAME")
	private String name;
	//�û���
//	@Column(name="USER_NAME")
//	private String username;
	//����
	@Column(name="PASSWORD")
	private String password;
	//����
	@Column(name="EMAIL")
	private String email;
	//�ֻ����
	@Column(name="CELLPHONE")
	private String cellphone;
	//����
	@Column(name="BIRTHDATE")
	private Date birthdate;
	//�Ա�
	@Column(name="GENDER")
	private String gender;
	//Ȩ��
	@ElementCollection
	private Set<GrantedAuthority> authorities;
	//
	@Column(name="ACCOUNTNONEXPIRED")
	private boolean accountNonExpired;
	//
	@Column(name="ACCOUNTNONBLOCKED")
	private boolean accountNonLocked;
	//
	@Column(name="CREDENTIALSNONEXPIRED")
	private boolean credentialsNonExpired;
	//�˺��Ƿ���Ч
	@Column(name="ENABLED")
	private boolean enabled;
	//��������
	@Column(name="CREATEDATE")
	private Date createDate;

	
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	public void eraseCredentials() {
		password = null;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
//		return username;
		return email;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<GrantedAuthority> getAuthories() {
		return authorities;
	}

	public void setAuthories(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setUsername(String username) {
//		this.username = username;
		this.email = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	 @SuppressWarnings("unused")
	private static SortedSet<GrantedAuthority> sortAuthorities(  
			   Collection<? extends GrantedAuthority> authorities) {  
			  Assert.notNull(authorities,  
			    "Cannot pass a null GrantedAuthority collection");  
			  // Ensure array iteration order is predictable (as per  
			  // UserDetails.getAuthorities() contract and SEC-717)  
			  SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(  
			    new AuthorityComparator());  
			  
			  for (GrantedAuthority grantedAuthority : authorities) {  
			   Assert.notNull(grantedAuthority,  
			     "GrantedAuthority list cannot contain any null elements");  
			   sortedAuthorities.add(grantedAuthority);  
			  }  
			  
			  return sortedAuthorities;  
			 }  
			  
	private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
		/**
		* 
	    */
	 private static final long serialVersionUID = 297651878571462717L;
	
	 public int compare(GrantedAuthority g1, GrantedAuthority g2) {
		 // Neither should ever be null as each entry is checked before  
		 // adding it to the set.  
		 // If the authority is null, it is a custom authority and should  
		 // precede others.  
		 if (g2.getAuthority() == null) {
			 return -1;  
		 }
		 if (g1.getAuthority() == null) {  
			 return 1;
		 }
		 return g1.getAuthority().compareTo(g2.getAuthority());  
	 	 }
	  }

 	@Override  
 	public boolean equals(Object rhs) {  
 		if (rhs instanceof User)
// 			return username.equals(((User) rhs).username);
 			return email.equals(((User)rhs).email);
 		return false;  
 	}  
  
 	@Override  
 	public int hashCode() {  
// 		return username.hashCode();
 		return email.hashCode();
 	}  
  
 	@Override  
 	public String toString() {  
 		StringBuilder sb = new StringBuilder();  
 		sb.append(super.toString()).append(": ");  
// 		sb.append("Username: ").append(this.username).append("; ");  
 		sb.append("Password: [PROTECTED]; ");  
 		sb.append("Enabled: ").append(this.enabled).append("; ");  
 		sb.append("AccountNonExpired: ").append(this.accountNonExpired).append(  
 				"; ");  
 		sb.append("credentialsNonExpired: ").append(this.credentialsNonExpired)  
 		.append("; ");  
 		sb.append("AccountNonLocked: ").append(this.accountNonLocked).append(  
 				"; ");  
  
 		if (!authorities.isEmpty()) {  
 			sb.append("Granted Authorities: ");  
  
 			boolean first = true;  
 			for (GrantedAuthority auth : authorities) {  
 				if (!first) {  
 					sb.append(",");  
 				}  
 				first = false;  
  
 				sb.append(auth);  
 			}  
 		} else {  
 			sb.append("Not granted any authorities");  
 		}  
 		return sb.toString();  
 	}
 	
 	public List<Role> getRoleList(){
 		List<Role> roles = new ArrayList<Role>();
 		
 		return roles;
 	}
}
