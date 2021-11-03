package com.esprit.td.services.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.td.entities.Product;
import com.esprit.td.repositories.ProductRepository;
import com.esprit.td.services.ProductService;



@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	

	
	private static final Logger L = LogManager.getLogger(ProductServiceImpl.class);

	@Override
	public List<Product> retrieveAllProducts() {
		// TODO Auto-generated method stub
		
		
		List<Product> products = (List<Product>) productRepository.findAll();
		
		for(Product product : products)
		{
			L.info("Product " + product);
		}
		return products;
	}

	@Override
	public List<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByPrice(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
		Product product = productRepository.findById(id).orElseThrow(null);
		
		productRepository.delete(product);
		
	}

	@Override
	public Product update(Product p) {
		
		Product newProduct = new Product();
		
		newProduct.setName(p.getName());
		newProduct.setPrice(p.getPrice());
		newProduct.setType(p.getType());
		newProduct.setUrl_product(p.getUrl_product());
		
		productRepository.save(newProduct);

		L.info("Product" + newProduct);
		return newProduct;
		
		
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		
		productRepository.save(product);
		
		return product;
	}

	@Override
	public Product retrieveProduct(int id) {
		
		Product p = productRepository.findById(id).orElseThrow(null);
		L.info("Produit : "  + p);
		return p;
	}

	@Override
	public List<Product> findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignProduitToStock(int produitId, int stockId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductToStock(int produitId, int stockId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> recupNames() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
