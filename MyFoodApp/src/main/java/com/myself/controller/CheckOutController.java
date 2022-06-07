package com.myself.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myself.Exception.ItemUnavailable;
import com.myself.Model.CheckOutPrice;
import com.myself.service.CheckOutInter;

@RestController
public class CheckOutController {
	
	@Autowired
	private CheckOutInter coi;

	@GetMapping("/bhukkad/bill/{cart_Id}")
	public CheckOutPrice findAllBill(@PathVariable("cart_Id") Integer cart_Id) {
		
		CheckOutPrice cop =  coi.totalBill(cart_Id);
		if(cop != null) {
			return cop;
		}
		else {
			throw new ItemUnavailable("Bill is not ready yet...!");
			}
	}
	
}
