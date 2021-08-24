/**
 * 
 */
package com.iot.serviceImp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.iot.dao.SimStatusDao;
import com.iot.dto.StatusDto;
import com.iot.dto.StatusUpdateDto;
import com.iot.entity.SimStatus;
import com.iot.service.LookupsService;


/**
 * @author dina.hammouda
 *
 */
@Service
public class LookupService implements LookupsService{
	
	@Autowired
	SimStatusDao simStatusDao;
	

	@Override
	public StatusDto updateStatus(StatusUpdateDto dto) throws NotFoundException {
		ModelMapper mapper = new ModelMapper();
		
	
		SimStatus status = simStatusDao.findById(dto.getId()).orElseThrow(NotFoundException::new);
		status.setStatusValue(dto.getStatusValue());
		status = simStatusDao.save(status);
		
		StatusDto statusDto = mapper.map(status, StatusDto.class);
		
		return statusDto;
	}


	@Override
	public void deleteStatus(int statusId) throws Exception {
	
		 simStatusDao.deleteById(statusId);
		
	}

}
