/**
 * 
 */
package com.iot.dto;

import java.util.List;

/**
 * @author dina.hammouda
 *
 */
public class Devices extends Response{
	
	private List<DeviceDto> devices;

	public List<DeviceDto> getDevices() {
		return devices;
	}

	public void setDevices(List<DeviceDto> devices) {
		this.devices = devices;
	}

}
