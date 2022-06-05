package com.masai.project.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserAlreadyExist extends RuntimeException{
       public UserAlreadyExist(String message) {
    	   super(message);
       }
}
