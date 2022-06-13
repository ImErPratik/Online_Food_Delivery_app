package com.myself.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myself.Exception.ItemUnavailable;
import com.myself.Exception.LoginThreadException;
import com.myself.Model.Cart;
import com.myself.Model.Item;
import com.myself.Model.Login;
import com.myself.Model.LoginStatus;
import com.myself.service.CartInterface;
import com.myself.service.LoginServiceInterface;

@RestController
public class CartController {

	@Autowired
	private CartInterface ci;
	
	@Autowired
	private LoginServiceInterface li;
	
	/*here we are get selected Item */
	@GetMapping("/bhukkad/cart/{rest_Id}/{item_id}")
	public ResponseEntity<Item> getOrderList(@PathVariable("rest_Id") Integer restId, 
												   @PathVariable("item_id") Integer itemId){
		
		Item liItem = ci.getItembyId(restId, itemId);
		
		return new ResponseEntity<Item>(liItem, HttpStatus.ACCEPTED);
	}
	
	/*to store the item in the cart*/
	@GetMapping("/bhukkad/cart/{user_Id}/{rest_id}/{item_id}/{quantity}")
	public ResponseEntity<Cart> storeItemnCart(
												@PathVariable("user_Id") Integer userId, 
			   									@PathVariable("rest_id") Integer restId,
			   									@PathVariable("item_id") Integer itemId,
			   									@PathVariable("quantity") Integer quantity){
		
//		Login status =  li.isTokenValid(key);
//		
//		if(status.getStatus() != LoginStatus.LOGGED_OUT) {
//		
//				Cart c = ci.storeItemwithUser(userId, restId, itemId , quantity);
//				if(c != null ) {
//					return new ResponseEntity<Cart>(c, HttpStatus.ACCEPTED);
//				}
//				else {
//					throw new ItemUnavailable("Your cart is empty !");
//				}
//		}else {
//			throw new LoginThreadException("Invalid user...!");
//		}
		
		
//			
					Cart c = ci.storeItemwithUser(userId, restId, itemId , quantity);
					if(c != null ) {
						return new ResponseEntity<Cart>(c, HttpStatus.ACCEPTED);
					}
					else {
						throw new ItemUnavailable("Your cart is empty !");
					}
	
	
}
	
	@DeleteMapping("/bhukkad/cart/{key}/{cart_id}")
	public ResponseEntity<String> deleteCart(@PathVariable("key") String key, @PathVariable("cart_id")Integer cartId){
		
		Login status =  li.isTokenValid(key);
		
		if(status.getStatus() != LoginStatus.LOGGED_OUT) {
		
				String s = ci.delivery(cartId);
				return new ResponseEntity<String>(s,HttpStatus.ACCEPTED);
		}else {
			throw new LoginThreadException("Invalid user...!");
		}
	}
	
}
