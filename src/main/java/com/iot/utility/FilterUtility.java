/**
 * 
 */
package com.iot.utility;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.iot.dao.DeviceDao;
import com.iot.dao.SimDao;
import com.iot.dao.SimStatusDao;
import com.iot.dto.DeviceDto;
import com.iot.dto.Devices;
import com.iot.dto.FilterAttributes;
import com.iot.dto.SearchCriteria;
import com.iot.dto.SearchOperation;
import com.iot.entity.Device;
import com.iot.specification.DevicesSpecifications;

/**
 * @author dina.hammouda
 *
 */
@Service
public class FilterUtility {
	@Autowired
	DeviceDao deviceDao;

	@Autowired
	SimDao simDao;

	@Autowired
	SimStatusDao simStatusDao;

	public DevicesSpecifications buildQuery(FilterAttributes filterAttributes) {
		DevicesSpecifications searchCriteria = new DevicesSpecifications();
		if (filterAttributes.getStatus() != 0) {
			searchCriteria.add(new SearchCriteria("status", filterAttributes.getStatus(), SearchOperation.Equal));
		}
		if (filterAttributes.getFromTemperature() != 0) {
			searchCriteria.add(new SearchCriteria("temperature", filterAttributes.getFromTemperature(),
					SearchOperation.GreaterThan));
		}
		if (filterAttributes.getToTemperature() != 0) {
			searchCriteria.add(
					new SearchCriteria("temperature", filterAttributes.getToTemperature(), SearchOperation.LessThan));
		}
		return searchCriteria;
	}

	public Devices getFilterResponse(DevicesSpecifications specifications, int pageNo) {
		Devices response = new Devices();
		ModelMapper mapper = new ModelMapper();

		Pageable paging = PageRequest.of(pageNo, 10, Sort.by("id").ascending());

		Page<Device> pageResult = deviceDao.findAll(specifications, paging);
		List<DeviceDto> dto = Arrays.asList(mapper.map(pageResult.getContent(), DeviceDto[].class));

		response.setDevices(dto);

		return response;
	}

}
