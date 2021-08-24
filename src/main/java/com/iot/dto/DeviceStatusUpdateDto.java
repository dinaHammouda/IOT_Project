/**
 * 
 */
package com.iot.dto;

/**
 * @author dina.hammouda
 *
 */

public class DeviceStatusUpdateDto {
   private Long deviceId;
   private int statusId;
public Long getDeviceId() {
	return deviceId;
}
public void setDeviceId(Long deviceId) {
	this.deviceId = deviceId;
}
public int getStatusId() {
	return statusId;
}
public void setStatusId(int statusId) {
	this.statusId = statusId;
}

}
