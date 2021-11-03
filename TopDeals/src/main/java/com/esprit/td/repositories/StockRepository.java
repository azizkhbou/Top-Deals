package com.esprit.td.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.td.entities.Stock;


@Repository
public interface StockRepository extends CrudRepository<Stock, Integer>{

}
