package com.myself.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.Model.Cart;
import com.myself.Model.CheckOutPrice;
import com.myself.Model.Item;
import com.myself.Reposotiory.CheckOutrepo;

@Service
public class CheckOutImpl implements CheckOutInter{
	
	@Autowired
	private CheckOutrepo cor;
	
	@Autowired
	private CartInterface ci;

	@Override
	public CheckOutPrice totalBill(Integer cart_Id) {
		
		Cart c = ci.getCartById(cart_Id);
		
		CheckOutPrice cop = new CheckOutPrice();
		
		if(c != null) {
			
			List<Item> liit = c.getLiItem();
			
			int sum = 0;
			
			for(int i=0; i<liit.size(); i++) {
				sum += liit.get(i).getPrice();
			}
			
			cop.setTotalCost(sum);
			cop.setTotalItem(liit.size());
			cop.setLdt(LocalDateTime.now());
			
			cor.save(cop);
			
			return cop;
		}
		
		return null;
	}
	
	

}
