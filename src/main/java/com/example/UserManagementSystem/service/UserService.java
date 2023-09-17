package com.example.UserManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.UserManagementSystem.DTO.UserDTO;
import com.example.UserManagementSystem.model.User;

public interface UserService {
	
	public UserDTO saveUser(UserDTO user);
    public UserDTO findUserByUserName(String userName);
	public List<UserDTO> findUserByFirstName(String firstName);
	public List<UserDTO> findUserByLastName(String lastName);
	public UserDTO findUserByEmailAddress(String emailAddress);
	public Optional<UserDTO> updateUserById(UserDTO user,Long id);
	public String deleteUserById(Long id);
//	public UserDTO saveUser(User user);
	public Page<UserDTO> getAllUsers(int pageNumber,int pageSize);
}
