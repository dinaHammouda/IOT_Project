/**
 * 
 */
package com.iot.dto;

import lombok.Data;

/**
 * @author dina.hammouda
 *
 */
@Data
public class SimDto {
	
	private int id;
	private int operatorCode;
	private StatusDto status;
	private CountryDto  country;
	
	


}
