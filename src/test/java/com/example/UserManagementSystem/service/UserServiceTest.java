/*
package com.example.UserManagementSystem.service;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.UserManagementSystem.DTO.UserDTO;
import com.example.UserManagementSystem.Repository.UserRepository;
import com.example.UserManagementSystem.model.User;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserServiceImpl userService;
	
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Test
	public void testsaveUser() {
            
			UserDTO userDTO=new UserDTO();
		    Date dateOfBirth1 = new Date(92,10,20);
		   userDTO.setId(1L);
		    userDTO.setUsername("John Smith");
		    userDTO.setFirstName("John1");
		    userDTO.setLastName("Smith");
		    userDTO.setEmail("john.smith1@gmail");
		    userDTO.setDateOfBirth(dateOfBirth1);
			//userService.saveUser(userDTO);
			
			User user=new User();
		    Date dateOfBirth = new Date(92,10,20);
		    user.setId(1L);
		    user.setUsername("Johnnas Smith");
		    user.setFirstName("Johnnas");
		    user.setLastName("Smith");
		    user.setEmail("Johnnas.smith@gmail");
		    user.setDateOfBirth(dateOfBirth1);
			
		User user1=userRepo.save(user);
		
		System.out.println(user1.getId());
			
				    
 org.assertj.core.api.Assertions.assertThat(userService.saveUser(userDTO).getId()).isEqualTo(user1.getId());
    
		
	}

	
	@Test
	public void testfindUserByUserName() {
		
		User user=new User();
		user.setId(1L);
		  Date dateOfBirth = new Date(92,10,1);
		user.setUsername("John Smith");
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setEmail("john.smith@gmail");
		user.setDateOfBirth(dateOfBirth);	
		userRepo.save(user);
		
		UserDTO listUser=userService.findUserByUserName("John Smith");

		User user1=userRepo.findByUsername("John Smith");
		
	    		//actual expected
   org.assertj.core.api.Assertions.assertThat(user1.getUsername()).isEqualTo(listUser.getUsername());

		
	}

	
	
	@Test
	public void testfindUserByFirstName() {
		
		User user=new User();
		  Date dateOfBirth = new Date(92,10,1);
			user.setId(1L);
		user.setUsername("John Smith");
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setEmail("john.smith@gmail");
		user.setDateOfBirth(dateOfBirth);	
		userRepo.save(user);
		
		List<UserDTO> listUserDTO=userService.findUserByFirstName("John");

		List<User> listuser=userRepo.findByFirstName("John");
				
   org.assertj.core.api.Assertions.assertThat(listuser.get(0).getFirstName()).isEqualTo(listUserDTO.get(0).getFirstName());

		
	}
	
	
	@Test
	public void testfindUserByLastName() {
		
		User user=new User();
		  Date dateOfBirth = new Date(92,10,1);
			user.setId(1L);
		user.setUsername("John Smith");
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setEmail("john.smith@gmail");
		user.setDateOfBirth(dateOfBirth);	
		userRepo.save(user);
		
		List<UserDTO> listUserDTO=userService.findUserByLastName("Smith");

		List<User> listuser=userRepo.findByLastName("Smith");
				
   org.assertj.core.api.Assertions.assertThat(listuser.get(0).getLastName()).isEqualTo(listUserDTO.get(0).getLastName());

		
	}
	
	
	@Test
	public void testfindUserByEmail() {
		
		User user=new User();
		user.setId(1L);
		  Date dateOfBirth = new Date(92,10,1);
		user.setUsername("John Smith");
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setEmail("john.smith@gmail");
		user.setDateOfBirth(dateOfBirth);	
		userRepo.save(user);
		
		UserDTO userDTO=userService.findUserByEmailAddress("john.smith@gmail");

		User listuser=userRepo.findByEmail("john.smith@gmail");
				
   org.assertj.core.api.Assertions.assertThat(listuser.getEmail()).isEqualTo(userDTO.getEmail());

		
	}
	
	
	@Test
	void testupdateUser() {
		
		 // Step 1: Set Up - Create or retrieve a user to update
		
     	UserDTO userDTO=new UserDTO();

		User user=new User();
		  Date dateOfBirth = new Date(92,10,1);
			//user.setId(1L);

		user.setUsername("John Smith");
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setEmail("john.smith@gmail");
		user.setDateOfBirth(dateOfBirth);
		userRepo.save(user);        
		user.setUsername("Johnas Doe"); 
		user.setEmail("johnas.smith@gmail");
		user.setLastName("Doe");
		
		userRepo.save(user);       

        Optional<User> updatedUser = userRepo.findById(user.getId());
        User retrievedUser = updatedUser.get();

        // Step 4: Assertions - Verify the update
       // Assertions.assertThat(retrievedUser).isNotNull();
        Assertions.assertThat(retrievedUser.getUsername()).isEqualTo("Johnas Doe");
        Assertions.assertThat(retrievedUser.getEmail()).isEqualTo("johnas.smith@gmail");
        Assertions.assertThat(retrievedUser.getLastName()).isEqualTo("Doe"); // Ensure that other fields are unchanged

	}
	
	
	@Test
	void testDeleteUser() {

		User user=new User();
		user.setId(1L);
		Date dateOfBirth = new Date(92,10,1);
		user.setUsername("John Smith");
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setEmail("john.smith@gmail");
		user.setDateOfBirth(dateOfBirth);	
		userRepo.save(user);
		
		String result=userService.deleteUserById(1L);
		
		
		System.out.println(result);
	//	Optional<User> userList=userRepo.findById(1L);
	//	System.out.println(userList);
			
		org.assertj.core.api.Assertions.assertThat(result).isEqualTo("User Deleted By "+1L);
	}
	
}
*/