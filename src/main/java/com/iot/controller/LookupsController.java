/**
 * 
 */
package com.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iot.dto.Response;
import com.iot.dto.StatusDto;
import com.iot.dto.StatusUpdateDto;
import com.iot.serviceImp.LookupService;
import com.iot.utility.Constants;

/**
 * @author dina.hammouda
 *
 */

@RestController
@RequestMapping("/v1/private/api")
public class LookupsController {
	
	
	@Autowired
	LookupService lookupService;
	
	@PatchMapping("/status")
	ResponseEntity<Response> updateStatus(@RequestBody StatusUpdateDto status) throws NotFoundException {
		StatusDto response = new StatusDto();
		try {
			response = lookupService.updateStatus(status);
		    response.setMessage(Constants.success); 
		} catch (Exception e) {
			Response error = new Response();
			error.setMessage(Constants.error_Bad_Request);
			
			return new ResponseEntity<Response>(error, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	@DeleteMapping("/status")
	ResponseEntity<Response> deleteStatus(@RequestParam(value = "statusId", required = false) int id) throws NotFoundException {
		Response response = new Response();
		try {
			lookupService.deleteStatus(id);
		    response.setMessage(Constants.success); 
		} catch (Exception e) {
			Response error = new Response();
			error.setMessage(Constants.error_Bad_Request);
			
			return new ResponseEntity<Response>(error, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

}
