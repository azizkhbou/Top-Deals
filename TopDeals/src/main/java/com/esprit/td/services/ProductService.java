package com.esprit.td.services;

import java.util.List;

import com.esprit.td.entities.Product;


public interface ProductService {

	List<Product> retrieveAllProducts();
	List<Product> findByName(String name);
	List<Product> findByPrice(double price);
	List<Product> findByType(String type);
	
	public void assignProduitToStock(int produitId, int stockId);
	public void deleteProductToStock(int produitId, int stockId);
	public List<Product> recupNames();

	
	
	void deleteProduct(int id);
	Product update(Product product);
	Product addProduct(Product product);
	Product retrieveProduct(int id);
}
