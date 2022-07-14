package com.myself.service;




import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.Exception.LoginThreadException;
import com.myself.Exception.UserNotFound;
import com.myself.Model.Login;
import com.myself.Model.LoginStatus;
import com.myself.Model.User;
import com.myself.Model.UserDTO;
import com.myself.Reposotiory.LoginCrudRepo;





@Service
public class LoginService implements LoginServiceInterface {

	@Autowired
	private UserInterfernceImpl user;
	
	@Autowired
	private LoginCrudRepo loginRepo;

	@Autowired
	private LoginHistoryService logService;

	@Override
	public Login isTokenValid(String token) {
		
		java.util.Optional<Login> opt = loginRepo.findByApiKey(token);
		
		if(opt.isPresent()) {
			
			Login currentLogin = opt.get();
			
			LocalDateTime expiry = currentLogin.getKeyExpiryDate();
			
			if(currentLogin.getStatus() == LoginStatus.LOGGED_IN && LocalDateTime.now().isBefore(expiry)) {
				return currentLogin;
			} else {

				currentLogin.revokeLogin();
				loginRepo.save(currentLogin);
				throw new UserNotFound("Login Key has expired please login again to generate a new key!");
			}
			
		} else {
			throw new UserNotFound("Invalid Login Key!");
		}
	}

	@Override
	public String logout(String key) {
		
		java.util.Optional<Login> opt = loginRepo.findByApiKey(key);
		
		if(opt.isPresent()) {
			
			//Getting the login object
			Login currentLogin = opt.get();
			
			//If the status is already logged_out we return
			if(currentLogin.getStatus() == LoginStatus.LOGGED_OUT) {
				return "User is already logged out";
			}
			
			
			//Calling the revoke login function as request by the user
			currentLogin.revokeLogin();
			
			//Persisting in the database
			//logService.storeHistory(currentLogin);
			currentLogin.setStatus( LoginStatus.LOGGED_OUT);
			loginRepo.save(currentLogin);
		} else {
			//Exception thrown if the key is not existing in the database
			throw new LoginThreadException("Invalid Login Key!");
		}
		
		//Message for successfull logout
		return "User logged out successfully!";
	
	}

	@Override
	public Login login(UserDTO loginInfo) {
		
		
		
		try {
			User u = user.findByUsernameAndPassword(loginInfo.getUserName() , loginInfo.getUserPassword());
			
			Login newlogin = null;
			
			if(u.getLogin() == null) {
				newlogin = new Login();
			} else {
				 newlogin = u.getLogin();
		 
			     newlogin.newLogin();
			   
			}
			
			logService.storeHistory(newlogin);
			
			newlogin.setStatus( LoginStatus.LOGGED_IN);
			loginRepo.save(newlogin);
			
			newlogin.setUser(u);
			return newlogin;
			
		} catch (Exception e) {
                  throw new LoginThreadException("login failed...!!");
		}
		
		
		
	}


	
	

}