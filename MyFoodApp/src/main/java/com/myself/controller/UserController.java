package com.myself.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myself.Exception.UserNotFound;
import com.myself.Model.User;
import com.myself.service.UserInterferce;

@RestController
public class UserController {
	
	@Autowired
	private UserInterferce ui;

	@PostMapping("/bhukkad/users")
	public ResponseEntity<User> storeUser(@RequestBody User u, HttpSession hs){
		
		User cm = ui.addUser(u);
		hs.setAttribute("Data", cm);
		
		return new ResponseEntity<User>(cm, HttpStatus.OK);
	}
	
	@GetMapping("/bhukkad/users/{id}")
    public ResponseEntity<User>	 getUserById(@PathVariable("id") Integer  userId , HttpSession hr){
		
		User u =  ui.findUserById(userId);
		
		if(u!=null) {
			return new ResponseEntity<User> (u, HttpStatus.OK);
		}
		else{
			throw new UserNotFound("UserId not Found.."+ userId);
		}
	}
	
	
	
}
