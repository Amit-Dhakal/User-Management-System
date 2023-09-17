package com.example.UserManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "USER MANAGEMENT SYSTEM", version = "1.0", description = "User Management Portal"))
public class UserManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementSystemApplication.class, args);
	}

}
