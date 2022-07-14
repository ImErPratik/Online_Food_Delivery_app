package com.myself.service;


import java.util.List;

import com.myself.Model.Cart;
import com.myself.Model.Item;

public interface CartInterface {
	
	public List<Item> getCartId(Integer cart_Id, Integer user_Id );
	
	public Cart getCartById(Integer cart_Id);
	
	public Item getItembyId(  Integer rest_Id, Integer item_id);
	
	public Cart storeItemwithUser(Integer user_Id, Integer rest_Id, Integer item_Id , Integer quantity);
    
	public String delivery(Integer cartId);
	
}
