package com.example.UserManagementSystem.DTO;
import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.Data;

@Data
public class UserDTO {
	
	private Long id;
	
	
	@NotNull(message="username should not be empty")
	private String username;
	
	@NotNull(message="firstname should not be empty")
	private String firstName;
	
	@NotNull(message="lastname should not be empty")
	private String lastName;
	
	@Email(message="Email is not valid !!")
	private String email;
	
    @Past(message = "Date of Birth should be a valid date and not in the future")
    @NotNull
	private Date dateOfBirth;

    
   private int pageNumber;
    private int pageSize;
}
