package com.masai.project.Exception;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class LoginThreadException extends RuntimeException{
	public LoginThreadException(String message) {
         super(message);
	}
}
