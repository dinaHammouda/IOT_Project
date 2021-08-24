/**
 * 
 */
package com.iot.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.iot.dto.StatusDto;
import com.iot.dto.StatusUpdateDto;


/**
 * @author dina.hammouda
 *
 */
public interface LookupsService {
	
	StatusDto updateStatus(StatusUpdateDto dto) throws NotFoundException;
	
	void deleteStatus(int statusId) throws NotFoundException;

}
