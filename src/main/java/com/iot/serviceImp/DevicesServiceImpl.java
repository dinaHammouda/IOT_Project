/**
 * 
 */
package com.iot.serviceImp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.iot.dao.DeviceDao;

import com.iot.dao.SimStatusDao;
import com.iot.dto.DeviceDto;
import com.iot.dto.Devices;
import com.iot.dto.FilterAttributes;
import com.iot.dto.StatusUpdateDto;
import com.iot.entity.Device;
import com.iot.entity.SimStatus;
import com.iot.service.devicesService;
import com.iot.specification.DevicesSpecifications;
import com.iot.utility.Constants;
import com.iot.utility.FilterUtility;

/**
 * @author dina.hammouda
 *
 */
@Service
public class DevicesServiceImpl implements devicesService {

	@Autowired
	DeviceDao deviceDao;



	@Autowired
	SimStatusDao simStatusDao;

	@Autowired
	FilterUtility filterUtility;

	@Override
	public Devices getDevicesByStatus(int status, int pageNo) throws NotFoundException {

		FilterAttributes filterAttributes = new FilterAttributes();
		filterAttributes.setStatus(status);

		Devices response = buildQuery(filterAttributes, pageNo);

		return response;
	}

	public DeviceDto updateDeviceStatus(StatusUpdateDto status) throws NotFoundException {

		ModelMapper mapper = new ModelMapper();

		Device deviceToUpdate = deviceDao.findById(status.getDeviceId()).orElseThrow(NotFoundException::new);
		SimStatus simStatus = simStatusDao.findById(status.getStatusId()).orElseThrow(NotFoundException::new);

		deviceToUpdate.getSimId().setStatus(simStatus);
		deviceToUpdate = deviceDao.save(deviceToUpdate);

		DeviceDto dto = mapper.map(deviceToUpdate, DeviceDto.class);

		return dto;
	}

	
	/**UK Standared **/
	public Devices getCongiguredDevices(int pageNo) throws NotFoundException {

		FilterAttributes filterAttributes = new FilterAttributes();
	
		SimStatus simStatus = simStatusDao.findByStatusKey(Constants.ready).orElseThrow(NotFoundException::new);
		
		filterAttributes.setStatus(simStatus.getId());
		filterAttributes.setFromTemperature(Constants.min_temp);
		filterAttributes.setToTemperature(Constants.max_temp);

		Devices response = buildQuery(filterAttributes, 0);

		return response;
	}

	
	private Devices buildQuery(FilterAttributes filterAttributes, int pageNo) {

		DevicesSpecifications specifications = filterUtility.buildQuery(filterAttributes);

		Devices response = filterUtility.getFilterResponse(specifications, pageNo);

		return response;

	}

}
