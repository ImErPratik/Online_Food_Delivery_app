package com.myself.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AddressAlreadyExists extends RuntimeException {
     
	public AddressAlreadyExists(String message) {
		super(message);
	}
	
	
}
