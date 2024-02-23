package com.example.UserManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserManagementSystem.DTO.UserDTO;
import com.example.UserManagementSystem.Exception.CustomException;
import com.example.UserManagementSystem.model.User;
import com.example.UserManagementSystem.service.UserService;

@RestController
@RequestMapping("/api")
public class UserManagementController{

	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<?> saveUser(@Valid @RequestBody UserDTO userDTO){
			
		
		try {
			userService.saveUser(userDTO);	

			return new ResponseEntity<>(userDTO,HttpStatus.ACCEPTED);
			
			
		} catch(CustomException e) {
			// TODO: handle exception
			CustomException ce=new CustomException(600,"Username and email value should not repeat !!");
		    return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);

		}
		
	}
	
	
	@GetMapping("/users/{username}")
	public ResponseEntity<?> findByUserName(@PathVariable String username){
			
		UserDTO userDTO=userService.findUserByUserName(username);
				
		return new ResponseEntity<>(userDTO,HttpStatus.ACCEPTED);
	}
	
		
	
	@GetMapping("/users/first-name/{firstName}")
	public ResponseEntity<?> findUserByfirstName(@PathVariable String firstName){
			
		List<UserDTO> user=userService.findUserByFirstName(firstName);
				
		return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/users/last-name/{lastName}")
	public ResponseEntity<?> findUserBylastName(@PathVariable String lastName){
			
		List<UserDTO> user=userService.findUserByLastName(lastName);
				
		return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/users/email/{email}")
	public ResponseEntity<?> findUserByEmail(@PathVariable String email){
			
		UserDTO user=userService.findUserByEmailAddress(email);
	
		
		return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
		
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUserById(@RequestBody UserDTO user,@PathVariable Long id){
			
		Optional<UserDTO> newuser=userService.updateUserById(user,id);
				
		return new ResponseEntity<>(newuser,HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long id){
			
		String message=userService.deleteUserById(id);		
		return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
	}
	

	/*
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers(
		@RequestParam(value="pageNumber",defaultValue ="1",required=false) int pageNumber,
		@RequestParam(value="pageSize",defaultValue ="10",required=false) int pageSize)
	
	{
			System.out.println(pageNumber);
			System.out.println(pageSize);

		List<UserDTO> allusers=userService.getAllUsers(pageNumber,pageSize);
	
		return new ResponseEntity<>(allusers,HttpStatus.OK);
		
	}
*/
	
	
	
	@GetMapping("/page/users")
	public ResponseEntity<?> getAllUsersPage(
		@RequestParam(value="pageNumber",defaultValue ="1",required=false) int pageNumber,
		@RequestParam(value="pageSize",defaultValue ="10",required=false) int pageSize)
	{
		
		
		Page<UserDTO> userPage=userService.getAllUsers(pageNumber,pageSize);
		
		
		return new ResponseEntity<>(userPage,HttpStatus.OK);
		
		
	}

	
	
}
