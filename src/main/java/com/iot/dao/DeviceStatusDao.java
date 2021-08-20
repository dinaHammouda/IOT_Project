/**
 * 
 */
package com.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iot.entity.DeviceStatus;

/**
 * @author dina.hammouda
 *
 */
public interface DeviceStatusDao extends JpaRepository<DeviceStatus, Integer>{

}
