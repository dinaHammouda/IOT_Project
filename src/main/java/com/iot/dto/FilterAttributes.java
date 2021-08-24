/**
 * 
 */
package com.iot.dto;


/**
 * @author dina.hammouda
 *
 */

public class FilterAttributes {
	 private int status;
	 private int fromTemperature;
	 private int toTemperature;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getFromTemperature() {
		return fromTemperature;
	}
	public void setFromTemperature(int fromTemperature) {
		this.fromTemperature = fromTemperature;
	}
	public int getToTemperature() {
		return toTemperature;
	}
	public void setToTemperature(int toTemperature) {
		this.toTemperature = toTemperature;
	}

}
