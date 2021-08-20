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
public class SearchCriteria {
	private String key;  //entity name
	private SearchOperation operation;
	private Object value;
	
	public SearchCriteria() {
    }

    public SearchCriteria(String key, Object value, SearchOperation operation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }
}
