package com.myself.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.Model.Item;
import com.myself.Model.Restaurants;
import com.myself.Reposotiory.ResturantsRepo;

@Service
public class ResturantsImpl implements ResturantsInter {

	@Autowired
	private ResturantsRepo rr;
	
	@Override
	public Restaurants addResturants(Restaurants r) {
		
		Restaurants saver = rr.save(r);
		
		return saver;
		
	}

	
	@Override
	public List<Item> getListofItembyRes_Id(Integer  restaurants_Id) {

		Optional<Restaurants> ob = rr.findById(restaurants_Id);
		
		if(ob.isPresent()) {
			
			Restaurants r = ob.get();
			
			return r.getItem_list();
		}
		
		return null;
	}


	@Override
	public Restaurants getresturantsbId(Integer id) {
		
		Optional<Restaurants> ob = rr.findById(id);
		
		if(ob.isPresent()) {
			
			Restaurants r = ob.get();
			
			return r;
		}
		
		return null;
		
		
	}
	
	

}
