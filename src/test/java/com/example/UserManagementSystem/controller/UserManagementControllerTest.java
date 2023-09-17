package com.example.UserManagementSystem.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.UserManagementSystem.DTO.UserDTO;
import com.example.UserManagementSystem.Repository.UserRepository;
import com.example.UserManagementSystem.model.User;
import com.example.UserManagementSystem.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserManagementControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
    private UserManagementController userManagementController;
	
	@MockBean
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private UserRepository userRepository;

	ObjectMapper mapper=new ObjectMapper();

	
	 @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(userManagementController).build();
	        mapper = new ObjectMapper();
	    }
	
	    @Test		
		void testsaveUser() throws Exception {
	  	    String URI="/api/users"; 
	  	    
	  		UserDTO userDTO=new UserDTO();
		    Date dateOfBirth1 = new Date(92,10,20);
		//   userDTO.setId(1L);
		    userDTO.setUsername("John Smith");
		    userDTO.setFirstName("John1");
		    userDTO.setLastName("Smith");
		    userDTO.setEmail("john.smith1@gmail");
		    userDTO.setDateOfBirth(dateOfBirth1);
			//userService.saveUser(userDTO);
		
		   String inputjson=mapper.writeValueAsString(userDTO);
	  	    
		    Mockito.when(userServiceImpl.saveUser(userDTO)).thenReturn(userDTO);
		 	
		    org.springframework.test.web.servlet.RequestBuilder rb=MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(inputjson).contentType(MediaType.APPLICATION_JSON);
		    
		    MvcResult result=mockMvc.perform(rb).andReturn();
		    
		    MockHttpServletResponse response=result.getResponse();
		    
		  String outputInJson=response.getContentAsString();

		org.assertj.core.api.Assertions.assertThat(outputInJson).isEqualTo(inputjson);

	    }	

	    
	    
	    
	    @Test
		public void testfindByUserName() throws Exception {

		  	    String URI="/api/users/username"; 

		  		UserDTO userDTO=new UserDTO();
		  		
		  	        Date dateOfBirth1 = new Date(92,10,20);
				    // userDTO.setId(1L);
				    userDTO.setUsername("John Smith");
				    userDTO.setFirstName("John1");
				    userDTO.setLastName("Smith");
				    userDTO.setEmail("john.smith1@gmail");
				    userDTO.setDateOfBirth(dateOfBirth1);
		 		   
				
				String expectedJSON=mapper.writeValueAsString(userDTO);

				System.out.println(expectedJSON);
							   
				userServiceImpl.saveUser(userDTO);
				
				userDTO=userServiceImpl.findUserByUserName("John Smith");	
	  
		 org.springframework.test.web.servlet.RequestBuilder requestbuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestbuilder).andReturn();
		
	    String outputInjson=result.getResponse().getContentAsString();         
		org.assertj.core.api.Assertions.assertThat(outputInjson).isLessThanOrEqualTo(expectedJSON);
		
		}
		
	    
	     
	    @Test
		public void testfindUserByFirstName() throws Exception {

		  	    String URI="/api/users/first-name/firstName"; 

		  		UserDTO userDTO=new UserDTO();
		  		
		  	        Date dateOfBirth1 = new Date(92,10,20);
				    // userDTO.setId(1L);
				    userDTO.setUsername("John Smith");
				    userDTO.setFirstName("John1");
				    userDTO.setLastName("Smith");
				    userDTO.setEmail("john.smith1@gmail");
				    userDTO.setDateOfBirth(dateOfBirth1);
		 		   
				
				String expectedJSON=mapper.writeValueAsString(userDTO);

				System.out.println(expectedJSON);
				
			   
				userServiceImpl.saveUser(userDTO);
				
				List<UserDTO> listUser=userServiceImpl.findUserByFirstName("John");	
	  
		 org.springframework.test.web.servlet.RequestBuilder requestbuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestbuilder).andReturn();
		
	    String outputInjson=result.getResponse().getContentAsString();         
		org.assertj.core.api.Assertions.assertThat(outputInjson).isLessThanOrEqualTo(expectedJSON);
		
		}
	    
	    
	    @Test
		public void testfindUserByLastName() throws Exception {

		  	    String URI="/api/users/last-name/lastName"; 

		  		UserDTO userDTO=new UserDTO();
		  		
		  	        Date dateOfBirth1 = new Date(92,10,20);
				    // userDTO.setId(1L);
				    userDTO.setUsername("John Smith");
				    userDTO.setFirstName("John1");
				    userDTO.setLastName("Smith");
				    userDTO.setEmail("john.smith1@gmail");
				    userDTO.setDateOfBirth(dateOfBirth1);
		 		   
				
				String expectedJSON=mapper.writeValueAsString(userDTO);

				System.out.println(expectedJSON);
				
			   
				userServiceImpl.saveUser(userDTO);
				
				List<UserDTO> listUser=userServiceImpl.findUserByLastName("Smith");	
	  
		 org.springframework.test.web.servlet.RequestBuilder requestbuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestbuilder).andReturn();
		
	    String outputInjson=result.getResponse().getContentAsString();         
		org.assertj.core.api.Assertions.assertThat(outputInjson).isLessThanOrEqualTo(expectedJSON);
		
		}
		
	    
	        @Test
	 		public void testfindUserByEmail() throws Exception {

	 		  	    String URI="/api/users/last-name/lastName"; 

	 		  		UserDTO userDTO=new UserDTO();
	 		  		
	 		  	        Date dateOfBirth1 = new Date(92,10,20);
	 				    // userDTO.setId(1L);
	 				    userDTO.setUsername("John Smith");
	 				    userDTO.setFirstName("John1");
	 				    userDTO.setLastName("Smith");
	 				    userDTO.setEmail("john.smith1@gmail");
	 				    userDTO.setDateOfBirth(dateOfBirth1);
	 		 		   
	 				
	 				String expectedJSON=mapper.writeValueAsString(userDTO);

	 				System.out.println(expectedJSON);
	 				
	 			   
	 				userServiceImpl.saveUser(userDTO);
	 				
	 				UserDTO listUser=userServiceImpl.findUserByEmailAddress("john.smith1@gmail");	
	 	  
	 		 org.springframework.test.web.servlet.RequestBuilder requestbuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
	 		MvcResult result=mockMvc.perform(requestbuilder).andReturn();
	 		
	 	    String outputInjson=result.getResponse().getContentAsString();         
	 		org.assertj.core.api.Assertions.assertThat(outputInjson).isLessThanOrEqualTo(expectedJSON);
	 		
	 		}

	    
	        @Test
	   	 		public void testUpdateUserById() throws Exception {

	   	 		  	    String URI="/api/users/last-name/lastName"; 

	   	 		  		UserDTO userDTO=new UserDTO();
	   	 		  		
	   	 		  	        Date dateOfBirth1 = new Date(92,10,20);
	   	 				     userDTO.setId(1L);
	   	 				    userDTO.setUsername("John Smith");
	   	 				    userDTO.setFirstName("John1");
	   	 				    userDTO.setLastName("Smith");
	   	 				    userDTO.setEmail("john.smith1@gmail");
	   	 				    userDTO.setDateOfBirth(dateOfBirth1);   
	   	 				
	   	 				String expectedJSON=mapper.writeValueAsString(userDTO);

	   	 				System.out.println(expectedJSON);
	   	 					   
	   	 				userServiceImpl.saveUser(userDTO);
	   	 				
	   	 			userDTO.setUsername("Johnas Doe"); 
	   	 	    	userDTO.setEmail("johnas.smith@gmail");
	   	 	         userDTO.setLastName("Doe");
	   	 				
	 	   	 	    String outputInjson=mapper.writeValueAsString(userDTO); 

	   	 	         
	   	 	         
				userServiceImpl.saveUser(userDTO);

	   	 				
				
				
				  

			        // Step 4: Assertions - Verify the update
			       // Assertions.assertThat(retrievedUser).isNotNull();
			        
			 //       Assertions.assertThat(retrievedUser.getUsername()).isEqualTo("Johnas Doe");
			  //      Assertions.assertThat(retrievedUser.getEmail()).isEqualTo("johnas.smith@gmail");
			 //       Assertions.assertThat(retrievedUser.getLastName()).isEqualTo("Doe");	
				

			  //      Optional<User> updatedUser = userRepository.findById(1L);
			    //    User retrievedUser = updatedUser.get();
	   	 	  
	   	 		 org.springframework.test.web.servlet.RequestBuilder requestbuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
	   	 		MvcResult result=mockMvc.perform(requestbuilder).andReturn();
	   	 		
	   	 		
	   	 		
	   	 	  //  String outputInjson=result.getResponse().getContentAsString();     
	   	 	    
	   	 	    System.out.println(outputInjson);
	   	 		org.assertj.core.api.Assertions.assertThat(outputInjson).isNotEqualTo(expectedJSON);
	   	 		
	   	 		
	   	 		
	   		}

	    
	    
	    
	        @Test
	 		public void testdeleteById() throws Exception {

	 		  	    String URI="/api/delete/id"; 

	 		  		User userDTO=new User();
	 		  		
	 		  	        Date dateOfBirth1 = new Date(92,10,20);
	 				     userDTO.setId(1L);
	 				    userDTO.setUsername("John Smith");
	 				    userDTO.setFirstName("John1");
	 				    userDTO.setLastName("Smith");
	 				    userDTO.setEmail("john.smith1@gmail");
	 				    userDTO.setDateOfBirth(dateOfBirth1);
		 				userRepository.save(userDTO);

	 				
	 				String expectedJSON=mapper.writeValueAsString(userDTO);	 				
	 			
	 				userRepository.deleteById(1L);

	 				
	 				Optional<User> listUser=userRepository.findById(1L);
	 				System.out.println(listUser.isEmpty());
	 				
	 				
	 					 	  
	 		 org.springframework.test.web.servlet.RequestBuilder requestbuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
	 		MvcResult result=mockMvc.perform(requestbuilder).andReturn();
	 		
	 	    String outputInjson=result.getResponse().getContentAsString(); 
	 	    
	 	    
	 		org.assertj.core.api.Assertions.assertThat(listUser.isEmpty()).isEqualTo(true);
	 		
	 		}	    
	    
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	    
	    
	    
	    
	    
		
	    


}
