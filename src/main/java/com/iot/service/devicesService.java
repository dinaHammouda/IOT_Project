/**
 * 
 */
package com.iot.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.iot.dto.DeviceDto;
import com.iot.dto.Devices;
import com.iot.dto.StatusUpdateDto;

/**
 * @author dina.hammouda
 *
 */
public interface devicesService {
	
	     Devices getDevicesByStatus(int status, int pageNo) throws NotFoundException;
	     
	     
	     DeviceDto updateDeviceStatus(StatusUpdateDto status) throws NotFoundException;

}
