package com.esprit.td.repositories;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.td.entities.Product;




@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	

}
