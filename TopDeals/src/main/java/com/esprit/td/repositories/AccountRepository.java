package com.esprit.td.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.td.entities.Account;


public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	public boolean existsByEmail (String email);

	public boolean existsByEmailAndId(String email, Integer id);

}
