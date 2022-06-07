package com.myself.Model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private Integer cart_Id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private User user;
	
	private Integer resturant_id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> liItem;
	

	

}

