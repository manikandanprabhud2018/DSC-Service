package com.cargill.customerfacing.dscportal.domain;

import java.util.Date;

public class ServiceContract {
	
	private int cakNo;
	private Date cakDate;
	private String commodity;
	private int quantity;
	private int received;
	private int balanceStock;
	private String contractType;
	private String customerId;
	public int getCakNo() {
		return cakNo;
	}
	public void setCakNo(int cakNo) {
		this.cakNo = cakNo;
	}
	public Date getCakDate() {
		return cakDate;
	}
	public void setCakDate(Date cakDate) {
		this.cakDate = cakDate;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getReceived() {
		return received;
	}
	public void setReceived(int received) {
		this.received = received;
	}
	public int getBalanceStock() {
		return balanceStock;
	}
	public void setBalanceStock(int balanceStock) {
		this.balanceStock = balanceStock;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
}
