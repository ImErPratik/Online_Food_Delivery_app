package com.myself.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myself.Exception.ItemUnavailable;
import com.myself.Exception.LoginThreadException;
import com.myself.Model.CheckOutPrice;
import com.myself.Model.Login;
import com.myself.Model.LoginStatus;
import com.myself.service.CheckOutInter;
import com.myself.service.LoginServiceInterface;

@RestController
public class CheckOutController {
	
	@Autowired
	private CheckOutInter coi;
	
	@Autowired
	private LoginServiceInterface li;

	@GetMapping("/bhukkad/bill/{cart_Id}/{key}")
	public CheckOutPrice findAllBill(@PathVariable("cart_Id") Integer cart_Id,@PathVariable String key) {
		
		Login status =  li.isTokenValid(key);
		
		if(status.getStatus() != LoginStatus.LOGGED_OUT) {
		
				CheckOutPrice cop =  coi.totalBill(cart_Id);
				if(cop != null) {
					return cop;
				}
				else {
					throw new ItemUnavailable("Bill is not ready yet...!");
					}
				
				
		}else {
				throw new LoginThreadException("Invalid user...!");
	}
	}
	
}
