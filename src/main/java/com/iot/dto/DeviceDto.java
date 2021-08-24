/**
 * 
 */
package com.iot.dto;

/**
 * @author dina.hammouda
 *
 */
public class DeviceDto extends Response{
	
	
	private long id;
	private int temperature;
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
	public SimDto getSimId() {
		return simId;
	}
	public void setSimId(SimDto simId) {
		this.simId = simId;
	}

}
