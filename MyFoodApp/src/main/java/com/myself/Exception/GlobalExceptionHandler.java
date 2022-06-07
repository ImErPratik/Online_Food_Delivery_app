package com.myself.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
   
	
	/*AddressAlreadyExists*/
	@ExceptionHandler(AddressAlreadyExists.class)
	public ResponseEntity<ErrorDetails> addressExistExpHandler(AddressAlreadyExists ae , WebRequest wa ){
		
		/*System.out.println("inside AdressExists method ");*/
	    ErrorDetails err = new ErrorDetails(LocalDateTime.now(),ae.getMessage(),wa.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.ALREADY_REPORTED);
		
	}
	
	/*AddressNotFoundException*/
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ErrorDetails> addUnavaiableExpHnadler(AddressNotFoundException anf ,WebRequest wa1){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), anf.getMessage(), wa1.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err , HttpStatus.NOT_FOUND);
	}
	
	/*ItemAlreadyFound*/
	@ExceptionHandler(ItemAlreadyFound.class)
	public ResponseEntity<ErrorDetails> itemexistsExpHandler(ItemAlreadyFound iaf,WebRequest wi){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), iaf.getMessage(), wi.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err , HttpStatus.ALREADY_REPORTED);
	}
	
	/*ItemUnavailable*/
	@ExceptionHandler(ItemUnavailable.class)
	public ResponseEntity<ErrorDetails> itemUnavailableExpHandler(ItemUnavailable iun,WebRequest wi1){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), iun.getMessage(), wi1.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err , HttpStatus.SEE_OTHER);
	}
	
	
	/*NoItemFoundIn*/
	@ExceptionHandler(NoItemFoundInFoodcart.class)
	public ResponseEntity<ErrorDetails> ItemNotFoundExpHandler(NoItemFoundInFoodcart nif,WebRequest wnif){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), nif.getMessage(), wnif.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err , HttpStatus.NOT_FOUND);
	}
	
	
	/*UserExists*/
	@ExceptionHandler(UserAlreadyExist.class)
	public ResponseEntity<ErrorDetails> UserExistsExpHandler(UserAlreadyExist uae,WebRequest wue){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), uae.getMessage(), wue.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err , HttpStatus.IM_USED);
	}
	
	
	/*UserNotFOund*/
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<ErrorDetails> UserdoesntExistsExpHandler(UserNotFound unf,WebRequest wunf){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), unf.getMessage(), wunf.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err , HttpStatus.NOT_FOUND);
	}
	
	/*Login*/
	@ExceptionHandler(LoginThreadException.class)
	public ResponseEntity<ErrorDetails> LoginExpHandler(LoginThreadException lte,WebRequest wlte){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(),lte.getMessage(), wlte.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err , HttpStatus.BAD_REQUEST);
	}
	
	/*MainException*/
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> myExpHandlerMain(Exception ie,WebRequest wr)  {
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
