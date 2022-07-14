package com.myself.Model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Login {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int loginId;
	
	private String apiKey = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
	
	private LocalDateTime keyExpiryDate = LocalDateTime.now().plusHours(4);
	
	private LoginStatus status = LoginStatus.LOGGED_IN;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@JsonIgnore
	public void newLogin() {
		this.apiKey = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
		this.keyExpiryDate = LocalDateTime.now().plusHours(4);
		this.status = LoginStatus.LOGGED_IN;
	}
	
	@JsonIgnore
	public void revokeLogin() {
		this.apiKey = null;
		this.keyExpiryDate = null;
		this.status = LoginStatus.LOGGED_OUT;
	}

//	public User getUser() {
//		// TODO Auto-generated method stub
//		return user;
//	}
//	
}
