package com.esprit.td.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.td.entities.Stock;
import com.esprit.td.services.StockService;



@RestController
public class StockRestControlImpl {
	
	@Autowired
	StockService stockService;
	
	@GetMapping(value="getAllStock")
	@ResponseBody
	public List<Stock> getAllStock(){
		return stockService.retrieveAll();
	}
	
	
	@DeleteMapping("/deleteStock/{stock-id}")
	@ResponseBody
	public void deleteStock(@PathVariable("stock-id") int stockId) {
		stockService.deleteStock(stockId);
	}
	
	@PostMapping("/addStock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock stock) {
		stockService.addStock(stock);
		return stock;
	}

}
