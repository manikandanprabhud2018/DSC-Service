package com.cargill.customerfacing.dscportal.domain;


public class AlertInfo {
	
	private int alertId;
	private String contractType;
	private String cascId;
	private String date;	
	private String contractNo;
	
	
	public int getAlertId() {
		return alertId;
	}
	public void setAlertId(int alertId) {
		this.alertId = alertId;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getCascId() {
		return cascId;
	}
	public void setCascId(String casc_id) {
		this.cascId = casc_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

}
