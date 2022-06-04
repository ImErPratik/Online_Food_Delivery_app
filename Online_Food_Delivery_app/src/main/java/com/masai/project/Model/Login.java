package com.masai.project.Model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int loginId;
	
	private String apiKey;
	
	private LocalDateTime keyExpiryDate;
	
	private LoginStatus status;
	
	@JsonIgnoreProperties("login")
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public void newLogin() {
		this.apiKey =  UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
		this.keyExpiryDate =  LocalDateTime.now().plusHours(4);
		this.status = LoginStatus.LOGGED_IN;
	}
	
	public void logOut() {
		this.apiKey =  null;
		this.keyExpiryDate =  null;
		this.status = LoginStatus.LOGGED_OUT;
	}
	
	
	
	

}
