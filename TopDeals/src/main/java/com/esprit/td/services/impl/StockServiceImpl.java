package com.esprit.td.services.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.esprit.td.entities.Stock;
import com.esprit.td.repositories.StockRepository;
import com.esprit.td.services.StockService;



@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockRepository stockRepository;
	
	private static final Logger L = LogManager.getLogger(StockServiceImpl.class);


	@Override
	@Secured("ROLE_ADMIN")

	public List<Stock> retrieveAll() {
		// TODO Auto-generated method stub
		
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		
		for(Stock stock : stocks) {
			L.info("stocks : " + stock);
		}
		return stocks;
	}

	@Override
	@Secured("ROLE_ADMIN")

	public Stock addStock(Stock stock) {
		// TODO Auto-generated method stub
		
		stockRepository.save(stock);
		
		return stock;
	}

	@Override
	@Secured("ROLE_ADMIN")

	public Stock retrieveStock(int id) {
		
		Stock stock = stockRepository.findById(id).orElseThrow(null);
		L.info("Stock" + stock);
		return stock;
	}

	@Override
	@Secured("ROLE_ADMIN")

	public Stock UpdateStock(Stock stock) {
		
		Stock newStock = new Stock();
		
		newStock.setStock_description(stock.getStock_description());
		newStock.setProduct_number(stock.getProduct_number());
		L.info("stock" + newStock);
		return newStock;
	}

	@Override
	@Secured("ROLE_ADMIN")

	public void deleteStock(int id) {
		// TODO Auto-generated method stub
		
		Stock stock = stockRepository.findById(id).orElseThrow(null);
		
		stockRepository.delete(stock);
		
	}

	@Override
	@Secured("ROLE_ADMIN")

	public List<Stock> recupTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
