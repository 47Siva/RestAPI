package com.EBRAIN.Staffes.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private List<Error> errors;
	public BadRequestException(String message, List<Error> errors) {
		super(message);
		this.errors = errors;
	}
	
	
}

