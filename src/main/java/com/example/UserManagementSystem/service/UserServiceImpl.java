package com.example.UserManagementSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.UserManagementSystem.DTO.UserDTO;
import com.example.UserManagementSystem.Exception.CustomException;
import com.example.UserManagementSystem.Repository.UserRepository;
import com.example.UserManagementSystem.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
   // private UserDTO userDTO=new UserDTO();

//	User user=new User();

	@Override
	public UserDTO saveUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		try {
			User user=new User();
			user.setId(userDTO.getId());
			user.setUsername(userDTO.getUsername());
			user.setFirstName(userDTO.getFirstName());
			user.setLastName(userDTO.getLastName());
			user.setEmail(userDTO.getEmail());
			user.setDateOfBirth(userDTO.getDateOfBirth());
		
			if(!userRepository.existsByUsername(userDTO.getUsername()) && !userRepository.existsByEmail(userDTO.getEmail())) {
				
				userRepository.save(user);
				
			}
			
			else {
				
	            throw new CustomException(600,"value must be unique");

				
			}

		} catch (CustomException e) {
			// TODO: handle exception
            throw new CustomException(601,"username value must be unique "+e.getMessage());	
		}catch (Exception e) {
			// TODO: handle exception
			
            throw new CustomException(603,"username is repeated"+e.getMessage());
			
		}
		
		return userDTO;

	}

	
	
	
	
	
	
	
	@Override
	public UserDTO findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		
		User user= userRepository.findByUsername(userName);
		
		    UserDTO userDTO=new UserDTO();			    
		    userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setFirstName(user.getFirstName());
			userDTO.setLastName(user.getLastName());
			userDTO.setEmail(user.getEmail());
			userDTO.setDateOfBirth(user.getDateOfBirth());
		
		return userDTO;

	}
	
	

	
	@Override
	public List<UserDTO> findUserByFirstName(String firstName) {
		// TODO Auto-generated method stub
		
	List<User> listuser= userRepository.findByFirstName(firstName);
	List<UserDTO> listuserDTO= new ArrayList<UserDTO>();

	for(User user:listuser) {
	
	    UserDTO userDTO=new UserDTO();
	    userDTO.setId(user.getId());
	    userDTO.setUsername(user.getUsername());
	    userDTO.setFirstName(user.getFirstName());
	    userDTO.setLastName(user.getLastName());
	    userDTO.setEmail(user.getEmail());
	    userDTO.setDateOfBirth(user.getDateOfBirth());
	    listuserDTO.add(userDTO);
	    
	}
	
		return listuserDTO;
				
	}

	@Override
	public List<UserDTO> findUserByLastName(String lastName) {
		// TODO Auto-generated method stub
		
		List<User> listUser= userRepository.findByLastName(lastName);
		List<UserDTO> userDTOList=new ArrayList<UserDTO>();
		
		for(User user:listUser)
		{
		    UserDTO userDTO=new UserDTO();
		    userDTO.setId(user.getId());
		    userDTO.setUsername(user.getUsername());
		    userDTO.setFirstName(user.getFirstName());
		    userDTO.setLastName(user.getLastName());
		    userDTO.setEmail(user.getEmail());
		    userDTO.setDateOfBirth(user.getDateOfBirth());
			userDTOList.add(userDTO);
		}
		
		return userDTOList;
	}

	@Override
	public UserDTO findUserByEmailAddress(String emailAddress) {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(emailAddress);
		
		    UserDTO userDTO=new UserDTO();
		    userDTO.setId(user.getId());
		    userDTO.setUsername(user.getUsername());
		    userDTO.setFirstName(user.getFirstName());
		    userDTO.setLastName(user.getLastName());
		    userDTO.setEmail(user.getEmail());
		    userDTO.setDateOfBirth(user.getDateOfBirth());
			
		return userDTO;
	}



	
	


	@Override
	public Optional<UserDTO> updateUserById(UserDTO userDTO,Long id) {
		// TODO Auto-generated method stub		
		
		User users=new User();

		Optional<User> listUserbeforeupdate= userRepository.findById(id);
		
		listUserbeforeupdate.ifPresent(user -> {
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setFirstName(user.getFirstName());
			userDTO.setLastName(user.getLastName());
			userDTO.setEmail(user.getEmail());
			userDTO.setDateOfBirth(user.getDateOfBirth());

		});
		
		
		users.setUsername(userDTO.getUsername());
		users.setFirstName(userDTO.getFirstName());
		users.setLastName(userDTO.getLastName());
		users.setEmail(userDTO.getEmail());
		users.setDateOfBirth(userDTO.getDateOfBirth());
		
		
		Optional<UserDTO> listUserBeforeUpdateDTO = Optional.of(userDTO);
		
		
		
		
		if(listUserBeforeUpdateDTO!=null) {
			
			userRepository.save(users);
		}
		
		
		return listUserBeforeUpdateDTO;
	}



	@Override
	public String deleteUserById(Long id) {
		// TODO Auto-generated method stub
		
		userRepository.deleteById(id);
		
		return "User Deleted By "+id; 
		
	}








	@Override
	public Page<UserDTO> getAllUsers(int pageNumber,int pageSize) {
		// TODO Auto-generated method stub
		/*
		 * Pageable pageable=PageRequest.of(pageNumber,pageSize);
		 * 
		 * User user=new User();
		 * 
		 * ModelMapper modelMapper = new ModelMapper();
		 * 
		 * 
		 * Page<User> pageUser=userRepository.findAll(pageable);
		 * 
		 * List<User> listUser=pageUser.getContent();
		 * 
		 * 
		 * List<UserDTO>
		 * listUserDTO=listUser.stream().map((users)->modelMapper.map(user,UserDTO.class
		 * )).collect(Collectors.toList());
		 * 
		 */
		ModelMapper modelMapper = new ModelMapper();
		
       Pageable pageable=PageRequest.of(pageNumber,pageSize);
		
		Page<User> userPage=userRepository.findAll(pageable);
		
		Page<UserDTO> userDTOPage = userPage.map(user -> modelMapper.map(user, UserDTO.class));
		
		
		return userDTOPage;
	}



	
}
