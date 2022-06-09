package com.myself.service;

import com.myself.Model.Login;

import com.myself.Model.UserDTO;

public interface LoginServiceInterface {
	
	public Login login(UserDTO loginInfo);
	
	public Login isTokenValid(String token);
	
	public String logout(String key);
	
}