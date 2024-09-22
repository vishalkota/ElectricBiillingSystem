package com.payment.exception;
 
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
 
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value= {ResourceNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	 protected ResponseEntity<Object> errorHandler(NullPointerException e, WebRequest req){
		MyErrorResponse error = new MyErrorResponse();
		 error.setMessage(e.getMessage());
		 error.setErrorCode("406");
		 error.setTime(new java.util.Date());
		 return handleExceptionInternal(e,error,
				 new HttpHeaders(),
				 HttpStatus.NOT_ACCEPTABLE,req);  // 5 arguments
	 }

 
	
	@ExceptionHandler(value= {Exception.class})
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	 protected ResponseEntity<Object> errorHandler(Exception e, WebRequest req){
		 MyErrorResponse error = new MyErrorResponse();
		 error.setMessage(e.getMessage());
		 error.setErrorCode("406");
		 error.setTime(new java.util.Date());
		 return handleExceptionInternal(e,error,new HttpHeaders(),
				 HttpStatus.NOT_ACCEPTABLE,req);
}
}