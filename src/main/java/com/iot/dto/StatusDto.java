/**
 * 
 */
package com.iot.dto;

/**
 * @author dina.hammouda
 *
 */
public class StatusDto extends Response{
	
	private int id;
	private String statusKey;
	private String statusValue;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStatusKey() {
		return statusKey;
	}
	public void setStatusKey(String statusKey) {
		this.statusKey = statusKey;
	}
	public String getStatusValue() {
		return statusValue;
	}
	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

}
