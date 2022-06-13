package com.myself.service;

import java.util.List;

import com.myself.Model.Item;
import com.myself.Model.Restaurants;

public interface ResturantsInter {
	
	public Restaurants addResturants(Restaurants r);
	
	public Restaurants getresturantsbId(Integer id);
	
	public Restaurants updateResturant(Restaurants res, Integer res_Id);
	
	public Restaurants deleteResturant(Integer resturantId);
	
	public List<Item> getListofItembyRes_Id(Integer  restaurants_Id); 
	
	

}
