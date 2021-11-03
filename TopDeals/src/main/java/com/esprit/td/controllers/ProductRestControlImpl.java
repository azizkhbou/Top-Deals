package com.esprit.td.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.td.entities.Product;
import com.esprit.td.services.ProductService;



@RestController
public class ProductRestControlImpl {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping(value="getProducts")
	@ResponseBody
	public List<Product> getListProducts() {
		return productService.retrieveAllProducts();
	}
	
	@PostMapping("/addProduct")
	@ResponseBody
	public Product addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return product;
	}
	
	@DeleteMapping("/deleteProduct/{product-id}")
	@ResponseBody
	public void deleteProduct(@PathVariable("product-id") int productId) {
		productService.deleteProduct(productId);
		
	}
	
	@PutMapping("/ModifyProduct")
	@ResponseBody
	public Product modifyProduct(@RequestBody Product product) {
		return productService.update(product);
	}
}
	
