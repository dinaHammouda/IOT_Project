/**
 * 
 */
package com.iot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iot.entity.Device;
import com.iot.entity.DeviceStatus;

/**
 * @author dina.hammouda
 *
 */
public interface DeviceDao extends JpaRepository<Device,Integer >{
	
	List<Device> findByDeviceStatus(DeviceStatus deviceStatus);

}
