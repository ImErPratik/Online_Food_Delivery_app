package com.myself.service;

import java.util.List;

import com.myself.Model.Item;
import com.myself.Model.Restaurants;

public interface ResturantsInter {
	
	public Restaurants addResturants(Restaurants r);
	
	public Restaurants getresturantsbId(Integer id);
	
	public List<Item> getListofItembyRes_Id(Integer  restaurants_Id); 
	
	

}
