/**
 * 
 */
package com.iot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iot.entity.SimStatus;

/**
 * @author dina.hammouda
 *
 */
public interface SimStatusDao extends JpaRepository<SimStatus, Integer>{

	Optional<SimStatus> findByStatusKey(String statusKey);
	
	

}
