package com.myself.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cart_Id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private User user;
	
	
	private Integer resturant_id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> liItem;
	

	

}

