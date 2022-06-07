package com.myself.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.Exception.UserNotFound;
import com.myself.Model.User;
import com.myself.Reposotiory.UserInter;


@Service
public class UserInterfernceImpl implements UserInterferce {

	@Autowired
	private UserInter ui;
	
	@Override
	public User addUser(User user) {
		
		User u = ui.save(user);
		
		return u;
	}

	@Override
	public User findUserById(Integer user_Id) {
		
		Optional<User> ob = ui.findById(user_Id);
		
		if(ob.isPresent()) {
			
			User u = ob.get();
			return u;
		}
		return null;
		
		
		
	}

	@Override
	public User findByUsernameAndPassword(String userName,String userPassword) {
	Optional<User> us = 	ui.findByUserNameAndUserPassword(userName, userPassword);
	
	if(us.isPresent()) {
	 return us.get();
	}
		return null;
	}
	
	

}
