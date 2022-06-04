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
import javax.validation.constraints.NotNull;

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
@Table(name = "items")

public class Item {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Item_id")
	private Integer itemId;
	
	@NotNull(message = "itemName cannot be null")
	private String itemName;
	
	
	@NotNull(message = "quantity cannot be null")
	private String quantity;
	
	@NotNull(message = "cost cannot be null")
	private double cost;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="category") 
	@JsonIgnoreProperties("category")
	private List<Restaurant> restaurants = new ArrayList<>();
	
}
