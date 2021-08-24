/**
 * 
 */
package com.iot.utility;

import org.springframework.stereotype.Service;

/**
 * @author dina.hammouda
 *
 */
@Service
public class Utilities {

	public boolean validate(String value) {

		if (value != null && !value.toString().matches(
				"^[a-zA-Z]*$")) {

			return false;
		}

		return true;
	}

}
