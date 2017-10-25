package com.cargill.customerfacing.dscportal.domain;

public class CustomerProfile {
	
	private String userId;
	private String email;
	private String firstName;
	private String lastname;
	private String language;
	private String customerId;
	private String activeFlag;
	private String cargillUser;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getCargillUser() {
		return cargillUser;
	}
	public void setCargillUser(String cargillUser) {
		this.cargillUser = cargillUser;
	}
	

}
