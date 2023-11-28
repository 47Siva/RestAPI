package com.EBRAIN.Staffes.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.EBRAIN.Staffes.common.Error;
import com.EBRAIN.Staffes.entity.Staffes;

@Component
public class StaffesValidator {

	public List<Error> validateCreateStaffesRequest(Staffes staffes) {
		 
		List <Error> errors = new ArrayList<Error>();
		// name 
		if (staffes.getName() == null) {
			Error error = new Error("name", "name is null");
			errors.add(error);
		}
		
		return  errors;		
	}
	

}
