/**
 * 
 */
package com.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iot.entity.SimStatus;


/**
 * @author dina.hammouda
 *
 */
@Repository
public interface StatusDao extends JpaRepository<SimStatus, Integer>{

}
