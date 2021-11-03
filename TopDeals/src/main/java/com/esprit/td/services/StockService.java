package com.esprit.td.services;

import java.util.List;

import com.esprit.td.entities.Stock;



public interface StockService {
	
	List<Stock> retrieveAll();
	
	Stock addStock(Stock stock);
	Stock retrieveStock(int id);
	Stock UpdateStock(Stock stock);
	void deleteStock(int id);
	
	public List<Stock> recupTypes();

	

}
