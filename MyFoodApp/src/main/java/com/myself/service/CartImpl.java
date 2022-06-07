package com.myself.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.Exception.ItemUnavailable;
import com.myself.Model.Cart;
import com.myself.Model.Item;
import com.myself.Model.Restaurants;
import com.myself.Model.User;
import com.myself.Reposotiory.CartRepo;

@Service
public class CartImpl implements CartInterface{
	
	@Autowired
	private CartRepo cr;
	
	@Autowired
	private ResturantsImpl ri;

	
	@Autowired
	private UserInterfernceImpl uii;
	
	@Override
	public Item getItembyId( Integer rest_Id, Integer item_id) {
		
		List<Item> liItem =  ri.getListofItembyRes_Id(rest_Id);
		
		for(Integer i=0; i<liItem.size(); i++) {
			if(liItem.get(i).getItem_id() == item_id) {
				return liItem.get(i);
			}
		}
		
		throw new ItemUnavailable("List is Empty..!");
		
	}

	@Override
	public List<Item> getCartId(Integer cart_Id, Integer user_Id) {
		
		Optional<Cart> c = cr.findById(cart_Id);
		
		if(c.isPresent()) {
			Cart cart = c.get();
			
			cart.getUser().getUserId();
			
			cart.setLiItem(null);
		}
		
		return null;
	}

	@Override
	public Cart storeItemwithUser(Integer user_Id, Integer cart_Id, Integer item_Id,Integer quantity) throws ItemUnavailable {


		Item i = getItembyId(cart_Id, item_Id);
		
		User u = uii.findUserById(user_Id);
		
		
		
		
		if( u!= null ) {
			
			Optional<Cart> opt= cr.findById(cart_Id);
			
			
			if(opt.isPresent()) {
				
				Cart existingCart= opt.get();
				
				List<Item> it =   existingCart.getLiItem();
				
				it.add(i);
			        
				existingCart.setLiItem(it);
				
				
				cr.save(existingCart);
				
				return existingCart;
				
			}
			else{
				throw new ItemUnavailable("Cart is Empty..!");
			}
		}
		
		else{
			throw new ItemUnavailable("Please enter correct credentials...");
		}
	}

	@Override
	public Cart getCartById(Integer cart_Id) {

		Optional<Cart> ob = cr.findById(cart_Id);
		
		if(ob.isPresent()) {
			
			Cart r = ob.get();
			
			return r;
		}
		
		return null;
	}

	@Override
	public String delivery(Integer cartId ) {
		//Cart ct = storeItemwithUser(userId, cartId, itemId);
		Cart  cg = getCartById(cartId);
	  List<Item> lit =  cg.getLiItem();
	  lit.clear();
//	  for(int i =0 ;i<lit.size();i++) {
//		  lit.removeAll(i);
//		
//	  }
	   cr.save(cg);
		return ("Delivery Successful ...");
	}
	
		
	
}






















