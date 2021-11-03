package com.esprit.td.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.td.entities.Deal;

public interface DealRepository extends JpaRepository<Deal, Integer> {
	
	

}
