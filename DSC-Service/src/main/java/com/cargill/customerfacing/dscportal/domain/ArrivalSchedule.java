package com.cargill.customerfacing.dscportal.domain;

import java.util.Date;

public class ArrivalSchedule {
	
	private String cargo;
	private String volume;
	private String tendered;
	private String shipmentPeriod;
	private String vesselName;
	private String warehouse;
	private Date eta;
	 private String contractType;
	 private String cakNo;
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getTendered() {
		return tendered;
	}
	public void setTendered(String tendered) {
		this.tendered = tendered;
	}
	public String getShipmentPeriod() {
		return shipmentPeriod;
	}
	public void setShipmentPeriod(String shipmentPeriod) {
		this.shipmentPeriod = shipmentPeriod;
	}
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public Date getEta() {
		return eta;
	}
	public void setEta(Date eta) {
		this.eta = eta;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getCakNo() {
		return cakNo;
	}
	public void setCakNo(String cakNo) {
		this.cakNo = cakNo;
	}
	 
	 

}