/**
 * 
 */
package com.iot.dto;

/**
 * @author dina.hammouda
 *
 */
public class DeviceDto {
	
	
	private long id;
	private int temperature;
	private StatusDto deviceStatus;
	private SimDto simId;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public StatusDto getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(StatusDto deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	public SimDto getSimId() {
		return simId;
	}
	public void setSimId(SimDto simId) {
		this.simId = simId;
	}

}
