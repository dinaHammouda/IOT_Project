/**
 * 
 */
package com.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.iot.entity.Device;


/**
 * @author dina.hammouda
 *
 */
public interface DeviceDao extends JpaRepository<Device,Long >, JpaSpecificationExecutor<Device>{
	
	

}
