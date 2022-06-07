package com.myself.Model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckOutPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bill_Id;
	private LocalDateTime ldt;
	private Integer totalItem;
	private Integer totalCost;
	
}
