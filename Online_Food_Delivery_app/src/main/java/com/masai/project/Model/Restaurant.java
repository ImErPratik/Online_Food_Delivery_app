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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "restaurants")
public class Restaurant {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "restaurant_id")
	private String restaurantId;
	
	@Column(name = "restaurant_name")
	@NotNull
	@Pattern(regexp="[a-z]{6,12}")
	private String restaurantName;
	
	@Column(name = "manager_name")
	@NotNull
	@Pattern(regexp="[a-z]{6,12}")
	private String managerrName;
	
	@NotNull
	@Pattern(regexp="[0-9]{10}", message = "Contact number must have 10 digits")
	private String contactNumber;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user") 
	@JsonIgnoreProperties("user")
	private List<Address> addresses = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="item") 
	@JsonIgnoreProperties("item")
	private List<Item> itemlists = new ArrayList<>();

}
