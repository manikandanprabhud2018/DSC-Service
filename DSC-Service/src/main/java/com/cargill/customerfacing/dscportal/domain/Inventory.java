package com.cargill.customerfacing.dscportal.domain;

import java.util.Date;

public class Inventory {
	
	private String cargo;
	private String trucksNo;
	private String bargeNo;
	private Date timeIn;
	private int weightIn;
	private Date timeOut;
	private String weightOut;
	private String totalWeight;
	private String packing;
	private String mode;
	private String location;
	private int pickupId;
	private int cakNo;
	private String contractType;
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getTrucksNo() {
		return trucksNo;
	}
	public void setTrucksNo(String trucksNo) {
		this.trucksNo = trucksNo;
	}
	public String getBargeNo() {
		return bargeNo;
	}
	public void setBargeNo(String bargeNo) {
		this.bargeNo = bargeNo;
	}
	public Date getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}
	public int getWeightIn() {
		return weightIn;
	}
	public void setWeightIn(int weightIn) {
		this.weightIn = weightIn;
	}
	public Date getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}
	public String getWeightOut() {
		return weightOut;
	}
	public void setWeightOut(String weightOut) {
		this.weightOut = weightOut;
	}
	public String getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}
	public String getPacking() {
		return packing;
	}
	public void setPacking(String packing) {
		this.packing = packing;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPickupId() {
		return pickupId;
	}
	public void setPickupId(int pickupId) {
		this.pickupId = pickupId;
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
