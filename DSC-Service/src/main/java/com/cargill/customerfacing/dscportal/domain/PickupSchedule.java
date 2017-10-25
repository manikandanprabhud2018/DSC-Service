package com.cargill.customerfacing.dscportal.domain;

import java.io.File;
import java.util.Date;

public class PickupSchedule {
	
	private Date date;
	private String pickupId;
	private File document;
	private int cakNo;
	private String contractType;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPickupId() {
		return pickupId;
	}
	public void setPickupId(String pickupId) {
		this.pickupId = pickupId;
	}
	public File getDocument() {
		return document;
	}
	public void setDocument(File document) {
		this.document = document;
	}
	public int getCakNo() {
		return cakNo;
	}
	public void setCakNo(int cakNo) {
		this.cakNo = cakNo;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	
}
