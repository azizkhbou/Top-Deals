package com.esprit.td.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.td.entities.User;





public interface UserRepository extends JpaRepository<User, Integer>  {
	public boolean existsByUsername(String username);

	public boolean existsByUsernameAndId(String username, Integer id);

	public User findByUsername(String username);

}
