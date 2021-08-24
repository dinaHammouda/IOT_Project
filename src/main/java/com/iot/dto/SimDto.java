/**
 * 
 */
package com.iot.dto;



/**
 * @author dina.hammouda
 *
 */

public class SimDto {
	
	private int id;
	private int operatorCode;
	private StatusDto status;
	private CountryDto  country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(int operatorCode) {
		this.operatorCode = operatorCode;
	}
	public StatusDto getStatus() {
		return status;
	}
	public void setStatus(StatusDto status) {
		this.status = status;
	}
	public CountryDto getCountry() {
		return country;
	}
	public void setCountry(CountryDto country) {
		this.country = country;
	}
	
	


}
