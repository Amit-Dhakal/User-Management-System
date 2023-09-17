package com.example.UserManagementSystem.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.UserManagementSystem.DTO.UserDTO;
import com.example.UserManagementSystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

User findByUsername(String userName);

List<User> findByFirstName(String firstName);

List<User> findByLastName(String lastName);

User findByEmail(String emailAddress);

Optional<User> findById(Long id);

boolean existsByUsername(String username);

boolean existsByEmail(String email);

//UserDTO save(UserDTO userDTO);
//public Optional<User> updateById(User user,Long id);

	
}
