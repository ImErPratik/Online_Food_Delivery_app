package com.myself.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserAlreadyExist extends RuntimeException{
      
	public UserAlreadyExist(String message) {
    	   super(message);
    }
}
