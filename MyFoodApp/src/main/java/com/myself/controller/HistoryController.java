package com.myself.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.myself.Exception.ItemUnavailable;
import com.myself.Model.LoginHistory;
import com.myself.service.LoginHostoryInterface;

@RestController
public class HistoryController {
	
	
	@Autowired
	private LoginHostoryInterface log;
	
	
	@GetMapping("/bhukkad/history")
	public ResponseEntity<List<LoginHistory>> getItemListHandler(){
		
		List<LoginHistory> li =  log.getAllHistory();
		
		if(li != null) {
			return new ResponseEntity<List<LoginHistory>>(li,HttpStatus.FOUND);
		}
		else {
		   throw new ItemUnavailable("History not found");
		}
	}

}
