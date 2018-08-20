package com.lee.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;
/**
 * 用户查询条件类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@Component
public class UserParams implements Serializable {
	private String userName;
	private String phoneNumber;
	private String organization;
	private String status;
	private Timestamp registerStart;
	private Timestamp registerEnd;
	private String isOnline;
	private Timestamp loginStart;
	private Timestamp loginEnd;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}
	
	public Timestamp getRegisterStart() {
		return registerStart;
	}
	public void setRegisterStart(Timestamp registerStart) {
		this.registerStart = registerStart;
	}
	public Timestamp getRegisterEnd() {
		return registerEnd;
	}
	public void setRegisterEnd(Timestamp registerEnd) {
		this.registerEnd = registerEnd;
	}
	public Timestamp getLoginStart() {
		return loginStart;
	}
	public void setLoginStart(Timestamp loginStart) {
		this.loginStart = loginStart;
	}
	public Timestamp getLoginEnd() {
		return loginEnd;
	}
	public void setLoginEnd(Timestamp loginEnd) {
		this.loginEnd = loginEnd;
	}
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("UserParams");
		if(userName!=null) result.append("{userName="+userName);
		if(phoneNumber!=null) result.append(", phoneNumber="+phoneNumber);
		if(organization!=null) result.append(", organization="+organization);
		if(status!=null) result.append(", status="+status);
		if(registerStart!=null) result.append(", registerStart="+registerStart);
		if(registerEnd!=null) result.append(", registerEnd="+registerEnd);
		if(isOnline!=null) result.append(", isOnline="+isOnline);
		if(loginStart!=null) result.append(", loginStart="+loginStart);
		if(loginEnd!=null) result.append(", loginEnd="+loginEnd);
		result.append(" }");
		return result.toString();
	}
}
