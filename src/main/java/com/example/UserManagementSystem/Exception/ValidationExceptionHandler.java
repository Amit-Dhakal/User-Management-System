package com.example.UserManagementSystem.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ValidationExceptionHandler {
	
	
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> customExceptionHandler(CustomException ex){
		
		String message=ex.getMessage();
						
				//(message,false);
		
		return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
		
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgumentsNotFoundException(MethodArgumentNotValidException ex){
		
		Map<String,String> responses=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			
			String fieldName=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			responses.put(fieldName,message);
			
			
		});
		
		return new ResponseEntity<>(responses,HttpStatus.BAD_REQUEST);
	
	
	}

}
