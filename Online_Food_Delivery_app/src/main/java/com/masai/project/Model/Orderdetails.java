package com.masai.project.Model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
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
@Table(name = "orderdetails")

public class Orderdetails {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer orderId;
	
	@NotNull(message = "orderDate cannot be null")
	private LocalDateTime orderDate;
		
	@NotNull(message = "orderStatus cannot be null")
	private String orderStatus;
	
	@ManyToOne(cascade=CascadeType.ALL) 
	@JsonIgnoreProperties("cart")
	@JsonIgnore
	private Foodcart foodcart;
}
