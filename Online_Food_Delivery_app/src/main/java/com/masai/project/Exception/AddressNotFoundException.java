package com.masai.project.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AddressNotFoundException extends RuntimeException {
     
	
	public AddressNotFoundException(String message) {
		super(message);
	}
}
