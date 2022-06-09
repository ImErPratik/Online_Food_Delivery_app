package com.myself.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myself.Exception.ItemUnavailable;
import com.myself.Model.Cart;
import com.myself.Model.Item;
import com.myself.service.CartInterface;

@RestController
public class CartController {

	@Autowired
	private CartInterface ci;
	
	/*here we are taking */
	@GetMapping("/bhukkad/cart/{rest_Id}/{item_id}")
	public ResponseEntity<Item> getOrderList(@PathVariable("rest_Id") Integer restId, 
												   @PathVariable("item_id") Integer itemId){
		
		Item liItem = ci.getItembyId(restId, itemId);
		
		return new ResponseEntity<Item>(liItem, HttpStatus.ACCEPTED);
	}
	
	/*to store the item in the cart*/
	@GetMapping("/bhukkad/cart/{user_Id}/{cart_id}/{item_id}/{quantity}")
	public ResponseEntity<Cart> storeItemnCart(@PathVariable("user_Id") Integer userId, 
			   									@PathVariable("cart_id") Integer cartId,
			   									@PathVariable("item_id") Integer itemId,
			   									@PathVariable("quantity") Integer quantity){
		
	Cart c = ci.storeItemwithUser(userId, cartId, itemId , quantity);
	if(c != null ) {
		return new ResponseEntity<Cart>(c, HttpStatus.ACCEPTED);
	}
	else {
		throw new ItemUnavailable("Your cart is empty !");
	}
	
	
}
	
	@DeleteMapping("/bhukkad/cart/{cart_id}")
	public ResponseEntity<String> deleteCart(@PathVariable("cart_id")Integer cartId){
		String s = ci.delivery(cartId);
		return new ResponseEntity<String>(s,HttpStatus.ACCEPTED);
	}
	
}
