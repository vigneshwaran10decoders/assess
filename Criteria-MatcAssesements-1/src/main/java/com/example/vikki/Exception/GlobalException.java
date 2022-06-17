package com.example.vikki.Exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptyInputException.class)
		
		public ResponseEntity<String>handleEmptyInput(EmptyInputException empty){
			return new ResponseEntity<String>("There is some field is Missing",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String>handleNoSuchElementException(NoSuchElementException emptys){
	        return new ResponseEntity<String>("There is No Employee Details in Db",HttpStatus.NOT_FOUND);
			
		}
	
	@ExceptionHandler(AlreadyExistException.class)
	public ResponseEntity<String>AlreadyException(AlreadyExistException empty){
		return new ResponseEntity<String>("Id is already Exits",HttpStatus.BAD_REQUEST);
}
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return new  ResponseEntity<Object>("Please change the Http Request", HttpStatus.NOT_FOUND);
	}

	
}
