package com.cargill.customerfacing.dscportal.domain;

import java.util.Arrays;

public class QRCodeGenerate {
	byte[] bytes;
	String charsetName;
	Inventory inventory;
	
	public QRCodeGenerate(byte[] bytes, String charsetName) {
		super();
		this.bytes = bytes;
		this.charsetName = charsetName;
	}
	@Override
	public String toString() {
		return "QRCode [bytes=" + Arrays.toString(bytes) + ", charsetName=" + charsetName + ", inventory=" + inventory
				+ "]";
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	public String getCharsetName() {
		return charsetName;
	}
	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
}
