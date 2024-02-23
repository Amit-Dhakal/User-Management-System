/*
package com.example.UserManagementSystem.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.UserManagementSystem.DTO.UserDTO;
import com.example.UserManagementSystem.model.User;
import com.example.UserManagementSystem.service.UserServiceImpl;

@SpringBootTest
class UserRepositoryTest {
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	void testsaveUser() {
		
		  Date dateOfBirth = new Date(92,10,1);
			User user=new User();
			user.setId(1L);
			user.setUsername("John Smith");
			user.setFirstName("John");
			user.setLastName("Smith");
			user.setEmail("john.smith@gmail");
			user.setDateOfBirth(dateOfBirth);	

			userRepo.save(user);	
		org.assertj.core.api.Assertions.assertThat(user.getId()).isGreaterThan(0);
	    
	}

	
	@Test
	void testfindByFirstName() {
			
	User user=new User();
	user.setId(1L);
	  Date dateOfBirth = new Date(92,10,1);
	user.setUsername("John Smith");
	user.setFirstName("John");
	user.setLastName("Smith");
	user.setEmail("john.smith@gmail");
	user.setDateOfBirth(dateOfBirth);	
	userRepo.save(user);
	
	List<User> listUser=userRepo.findByFirstName("John");

	System.out.println(listUser.get(0).getFirstName());
	//System.out.println(user.getFirstName());

	org.assertj.core.api.Assertions.assertThat(user.getFirstName()).isEqualTo(listUser.get(0).getFirstName());

		
	}
	
	
	@Test
	void testfindBylastName() {
			
	User user=new User();
	user.setId(1L);
	  Date dateOfBirth = new Date(92,10,1);
	user.setUsername("John Smith");
	user.setFirstName("John");
	user.setLastName("Smith");
	user.setEmail("john.smith@gmail");
	user.setDateOfBirth(dateOfBirth);	
	userRepo.save(user);
	
	List<User> listUser=userRepo.findByLastName("Smith");

	System.out.println(listUser.get(0).getLastName());
	System.out.println(user.getLastName());

	org.assertj.core.api.Assertions.assertThat(user.getLastName()).isEqualTo(listUser.get(0).getLastName());
	

		
	}

	@Test
	void testfindByUsername() {
			
	User user=new User();
	user.setId(1L);
	  Date dateOfBirth = new Date(92,10,1);
	user.setUsername("John Smith");
	user.setFirstName("John");
	user.setLastName("Smith");
	user.setEmail("john.smith@gmail");
	user.setDateOfBirth(dateOfBirth);	
	userRepo.save(user);
	
	User listUser=userRepo.findByUsername("John Smith");

	System.out.println(listUser.getUsername());
	System.out.println(user.getUsername());

	org.assertj.core.api.Assertions.assertThat(user.getUsername()).isEqualTo(listUser.getUsername());
	}

	
	@Test
	void testfindByEmail() {
		
		User user=new User();
		user.setId(1L);
		Date dateOfBirth = new Date(92,10,1);
		user.setUsername("John Smith");
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setEmail("john.smith@gmail");
		user.setDateOfBirth(dateOfBirth);	
		userRepo.save(user);
		
		User listUser=userRepo.findByEmail("john.smith@gmail");

		//System.out.println(listUser.getEmail());
		//System.out.println(user.getUsername());
		org.assertj.core.api.Assertions.assertThat(user.getEmail()).isEqualTo(listUser.getEmail());
		
	}
	
	@Test
	void testfindById() {
		
		User user=new User();
		user.setId(1L);
		Date dateOfBirth = new Date(92,10,1);
		user.setUsername("John Smith");
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setEmail("john.smith@gmail");
		user.setDateOfBirth(dateOfBirth);	
		userRepo.save(user);
	
	Optional<User> optionalUser=userRepo.findById(1L);
	
    User retrievedUser = optionalUser.get();
			
	org.assertj.core.api.Assertions.assertThat(user).isEqualTo(retrievedUser);

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
		userRepo.deleteById(1L);		
		Optional<User> userList=userRepo.findById(1L);
		System.out.println(userList);
		
		
		org.assertj.core.api.Assertions.assertThat(userList.isEmpty()).isEqualTo(true);
	
	}

}

 */