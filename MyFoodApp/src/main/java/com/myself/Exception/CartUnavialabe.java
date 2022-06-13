package com.myself.Exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CartUnavialabe  extends RuntimeException{
	public CartUnavialabe(String message) {
 	   super(message);
    }
}