package com.cargill.customerfacing.dscportal.domain;

import java.io.Serializable;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Payment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6535122179629063219L;
	
	private String cakNo;
	private String status;
	private Date date;
	private String amount;
	private String contractType;
	@JsonIgnoreProperties
	private File file;
	
	public String getCakNo() {
		return cakNo;
	}
	public void setCakNo(String cakNo) {
		this.cakNo = cakNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}
