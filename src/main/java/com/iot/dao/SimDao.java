/**
 * 
 */
package com.iot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iot.entity.Sim;
import com.iot.entity.SimStatus;

/**
 * @author dina.hammouda
 *
 */
public interface SimDao  extends JpaRepository<Sim, Long>{
	
	List<Sim> findByStatus(SimStatus status);

}
