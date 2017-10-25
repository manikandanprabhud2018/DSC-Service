package com.cargill.customerfacing.dscportal.domain;

public class Contract {
	private int cakNo;
	private int approvedQty;
	private String contractType;
	private String status;
	private String customerId;
	
	public int getCakNo() {
		return cakNo;
	}
	public void setCakNo(int cakNo) {
		this.cakNo = cakNo;
	}
	public int getApprovedQty() {
		return approvedQty;
	}
	public void setApprovedQty(int approvedQty) {
		this.approvedQty = approvedQty;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
