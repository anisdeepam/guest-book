package com.guestbook.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/**
 * This is for GuestBook Application properties
 * @author Anis Deepa
 *
 */

import com.guestbook.Constants.GuestBookAppConstants;
@Configuration
@ConfigurationProperties(prefix = GuestBookAppConstants.GUEST_BOOK_LOGIN)
public class GuestBookProperties {
	
    private String userName;
    private String userPwd;
    private String userRole;
    private String adminName;
    private String adminPwd;
    private String adminRole;
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
}
