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
@Table(name = "bills")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_id")
	private Integer billId;
	
	@NotNull(message = "billDate cannot be null")
	private LocalDateTime billDate;
	
	
	@NotNull(message = "totalItem cannot be null")
	private int totalItem;
	
	@NotNull(message = "totalCost cannot be null")
	private double totalCost;
	
	@ManyToOne(cascade=CascadeType.ALL) 
	@JsonIgnoreProperties("orderId")
	@JsonIgnore
	private Orderdetails orderdetails;
}
