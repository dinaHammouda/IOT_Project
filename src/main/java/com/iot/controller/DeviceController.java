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
import com.iot.dto.Response;
import com.iot.dto.StatusUpdateDto;
import com.iot.serviceImp.DevicesServiceImpl;
import com.iot.utility.Constants;

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
	ResponseEntity<Response> getDevices(@RequestParam(defaultValue = "0", value = "statusId", required = false) int id,
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(value = "verified", required = false) boolean verified) throws NotFoundException {
		Devices response = new Devices();
    
		try {
			if (verified) {
				response = devicesService.getCongiguredDevices(pageNo);
			} else {
				response = devicesService.getDevicesByStatus(id, pageNo);
			}
		    response.setMessage(Constants.success); 
		} catch (Exception e) {
			Response error = new Response();
			error.setMessage(Constants.error_Bad_Request);
			return new ResponseEntity<Response>(error, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PatchMapping("/device-status")
	ResponseEntity<Response> updateStatus(@RequestBody StatusUpdateDto status) throws NotFoundException {
		DeviceDto response = new DeviceDto();
		try {
			response = devicesService.updateDeviceStatus(status);
		    response.setMessage(Constants.success); 
		} catch (Exception e) {
			Response error = new Response();
			error.setMessage(Constants.error_Bad_Request);
			
			return new ResponseEntity<Response>(error, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

}
