package com.cargill.customerfacing.dscportal.domain;

public class MarketInformation {
	
	private String heading;
	private String details;
	private int markId;
	private String status;
	private String contractType;
	
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getMarkId() {
		return markId;
	}
	public void setMarkId(int markId) {
		this.markId = markId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
}
