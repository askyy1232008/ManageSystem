package com.lee.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class AccountParams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String email;
	private String password;
	private String oldPwd;
	private String newPwd;
	
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
