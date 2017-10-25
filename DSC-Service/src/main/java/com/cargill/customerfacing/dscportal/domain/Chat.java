package com.cargill.customerfacing.dscportal.domain;

import java.io.File;

public class Chat {
	private String userId;
	private int cakNo;
	private String channelId;
	private File document;
	private String messageDetails;
	private String contractType;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getCakNo() {
		return cakNo;
	}
	public void setCakNo(int cakNo) {
		this.cakNo = cakNo;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getMessageDetails() {
		return messageDetails;
	}
	public void setMessageDetails(String messageDetails) {
		this.messageDetails = messageDetails;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public File getDocument() {
		return document;
	}
	public void setDocument(File document) {
		this.document = document;
	}
	
	
}
