package com.example.UserManagementSystem.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException{

	
	private int errorCode;
	private String message;
	
	
	
	
}
