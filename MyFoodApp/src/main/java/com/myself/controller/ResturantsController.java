package com.myself.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myself.Exception.ItemUnavailable;
import com.myself.Exception.LoginThreadException;
import com.myself.Exception.UserNotFound;
import com.myself.Model.Item;
import com.myself.Model.Login;
import com.myself.Model.LoginStatus;
import com.myself.Model.Restaurants;
import com.myself.service.LoginServiceInterface;
import com.myself.service.ResturantsInter;


@RestController
public class ResturantsController {
	
	@Autowired
	private ResturantsInter ri;
	
	@Autowired
	private LoginServiceInterface li;
	

	@PostMapping("/bhukkad/resturants")
	public ResponseEntity<Restaurants> storeResturant(@RequestBody Restaurants r){
		
		Restaurants cm = ri.addResturants(r);

		return new ResponseEntity<Restaurants>(cm, HttpStatus.OK);
	}
	
	@GetMapping("/bhukkad/resturants/{id}")
	public ResponseEntity<Restaurants> getResturantsHandler(@PathVariable("id") Integer id){
		
		Restaurants cm = ri.getresturantsbId(id);
		 if(cm!=null) {
			 return new ResponseEntity<Restaurants>(cm, HttpStatus.ACCEPTED);
		 }
		
		
             throw new UserNotFound("Restaurant by this restaurantId:-"+ id +" is not found");
	}

	
	@GetMapping("/bhukkad/resturants/item/{id}")
	public ResponseEntity<List<Item>> getItemListHandler(@PathVariable("id") Integer id){
		
		List<Item> li =  ri.getListofItembyRes_Id(id);
		
		if(li != null) {
			return new ResponseEntity<List<Item>>(li,HttpStatus.FOUND);
		}
		else {
		   throw new ItemUnavailable("Item not found");
		}
	}
	
	
	@PostMapping("/bhukkad/resturants/{id}")
	public ResponseEntity<Restaurants> updateResturants(@RequestBody Restaurants r, @PathVariable("id") Integer id){
		
		Restaurants updatedRes =  ri.updateResturant(r, id);
		
		if(updatedRes != null) {
			return new ResponseEntity<Restaurants>(updatedRes,HttpStatus.FOUND);
		}
		else {
		   throw new ItemUnavailable("Item not found");
		}
	}
	
	@DeleteMapping("/bhukkad/resturants/{id}/{key}")
	public ResponseEntity<Restaurants> deleteResturantsId( @PathVariable("id") Integer id, @PathVariable("key") String key){
		
		Login status =  li.isTokenValid(key);
		
		if(status.getStatus() != LoginStatus.LOGGED_OUT) {
			
			Restaurants deletedRes =  ri.deleteResturant(id);
			
			
			if(deletedRes != null) {
				return new ResponseEntity<Restaurants>(deletedRes,HttpStatus.FOUND);
			}
			else {
			   throw new ItemUnavailable("Resturants not found");
			}
			
			
		}
		
		else {
			throw new LoginThreadException("Invalid user...!");
		}
		
	}
}



























