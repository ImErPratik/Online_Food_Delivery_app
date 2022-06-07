package com.myself.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer item_id;
	
	private String item_name;
	
	private String category;
	
	private double price;
	
	private Integer quantity = 1;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Restaurants resturants;
	
	
}
