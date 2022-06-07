package com.myself.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myself.Exception.ItemUnavailable;
import com.myself.Exception.UserNotFound;
import com.myself.Model.Item;
import com.myself.Model.Restaurants;
import com.myself.service.ResturantsInter;


@RestController
public class ResturantsController {
	
	@Autowired
	private ResturantsInter ri;
	

	@PostMapping("/bhukkad/resturants")
	public ResponseEntity<Restaurants> storeResturant(@RequestBody Restaurants r, HttpSession hs){
		
		Restaurants cm = ri.addResturants(r);
		
		hs.setAttribute("Data", cm);
		
		return new ResponseEntity<Restaurants>(cm, HttpStatus.OK);
	}
	
	@GetMapping("/bhukkad/resturants/{id}")
	public ResponseEntity<Restaurants> getResturantsHandler(@PathVariable("id") Integer id, HttpSession hs){
		
		Restaurants cm = ri.getresturantsbId(id);
		 if(cm!=null) {
			 return new ResponseEntity<Restaurants>(cm, HttpStatus.ACCEPTED);
		 }
		
		hs.setAttribute("Data", cm);
		
             throw new UserNotFound("Restaurant by this restaurantId:-"+ id +" is not found");
	}

	
	@GetMapping("/bhukkad/resturants/item/{id}")
	public ResponseEntity<List<Item>> getItemListHandler(@PathVariable("id") Integer id, HttpSession hs){
		
		List<Item> li =  ri.getListofItembyRes_Id(id);
		hs.setAttribute("Data", li);
		if(li != null) {
			return new ResponseEntity<List<Item>>(li,HttpStatus.FOUND);
		}
		else {
		   throw new ItemUnavailable("Item not found");
		}
	}
}


























