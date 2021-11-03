package com.esprit.td.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.td.entities.Administrator;


public interface AdministratorRepository extends JpaRepository<Administrator, Integer>  {
	public boolean existsByUsername(String username);

	public boolean existsByUsernameAndId(String username, Integer id);

	public Administrator findByUsername(String username);

}
