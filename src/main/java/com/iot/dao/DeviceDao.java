/**
 * 
 */
package com.iot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.iot.entity.Device;
import com.iot.entity.DeviceStatus;

/**
 * @author dina.hammouda
 *
 */
public interface DeviceDao extends JpaRepository<Device,Long >, JpaSpecificationExecutor<Device>{
	
	List<Device> findByDeviceStatus(DeviceStatus deviceStatus);

}
