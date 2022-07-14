package com.myself.service;

import java.util.List;

import com.myself.Model.Login;
import com.myself.Model.LoginHistory;

public interface LoginHostoryInterface {
	
	
	public void storeHistory(Login log);
	
	public List<LoginHistory> getAllHistory();

}