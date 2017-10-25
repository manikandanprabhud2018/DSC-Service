package com.cargill.customerfacing.dscportal.domain;

public class UserSecurityToken {
	
	  private String userId;
	  private String userToken;
	  private String tokenDesc;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getTokenDesc() {
		return tokenDesc;
	}
	public void setTokenDesc(String tokenDesc) {
		this.tokenDesc = tokenDesc;
	}
	  
	  

}
