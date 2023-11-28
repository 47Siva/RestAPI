package com.EBRAIN.Staffes.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {

	private String target;
	
	private String message;
}
