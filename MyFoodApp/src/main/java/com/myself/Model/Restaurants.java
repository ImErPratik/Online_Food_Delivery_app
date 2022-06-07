package com.myself.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer restaurants_Id;
	
	private String res_name;
	
	@NotNull(message = "address cannot be null")
	private String address;
	
	@NotNull(message = "city cannot be null")
	private String city;
	
	@NotNull(message = "state cannot be null")
	private String state;
	
	@NotNull
	@Pattern(regexp="[0-9]{6}", message = "Only Valid for 6 digit indian pincode")
	private String pincode;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> item_list = new ArrayList<>();
	
	
}
