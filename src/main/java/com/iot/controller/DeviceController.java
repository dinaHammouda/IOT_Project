/**
 * 
 */
package com.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iot.dto.DeviceDto;
import com.iot.dto.Devices;
import com.iot.dto.StatusUpdateDto;
import com.iot.serviceImp.DevicesServiceImpl;

/**
 * @author dina.hammouda
 *
 */
@RestController
@RequestMapping("/v1/private/api")
public class DeviceController {

	@Autowired
	DevicesServiceImpl devicesService;

	@GetMapping("/devices")
	ResponseEntity<Devices> getDevices(@RequestParam(defaultValue = "0", value = "statusId", required = false) int id,
			@RequestParam(defaultValue = "0") Integer pageNo) throws NotFoundException {
		
		

		Devices response = devicesService.getDevicesByStatus(id,pageNo);

		return new ResponseEntity<Devices>(response, HttpStatus.OK);

	}
	
	@PatchMapping("/device-status")
	ResponseEntity<DeviceDto> updateStatus(@RequestBody StatusUpdateDto status) throws NotFoundException {

		DeviceDto response = devicesService.updateDeviceStatus(status);

		return new ResponseEntity<DeviceDto>(response, HttpStatus.OK);

	}
	
	
	@GetMapping("/configured-devices")
	ResponseEntity<Devices> getConfiguredDevices(@RequestParam(defaultValue = "0") Integer pageNo) throws NotFoundException {
        
		
		Devices response = devicesService.getCongiguredDevices(pageNo);

		return new ResponseEntity<Devices>(response, HttpStatus.OK);

	}
	
	


}
