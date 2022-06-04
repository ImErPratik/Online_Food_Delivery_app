package com.masai.project.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "foodcart")
public class Foodcart {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cartr_id")
	private String cartId;
	
//	private String itemlist;

	@ManyToOne(cascade=CascadeType.ALL) 
	@JsonIgnoreProperties("userName")
	@JsonIgnore
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Item_id") 
	@JsonIgnoreProperties("Item_id")
	private List<Item> item = new ArrayList<>();
	
}
