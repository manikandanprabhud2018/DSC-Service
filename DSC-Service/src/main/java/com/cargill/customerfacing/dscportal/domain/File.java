package com.cargill.customerfacing.dscportal.domain;

import java.io.Serializable;

public class File implements Serializable {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private String name;
    private String type;
    private Long size;
    private byte[] bytes;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	
    
}
