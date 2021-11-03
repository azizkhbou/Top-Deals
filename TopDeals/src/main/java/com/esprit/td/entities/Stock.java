package com.esprit.td.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_Stock")

public class Stock implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStock;
	
	private Long product_number;
	
	private String stock_description;
	
	@Enumerated(EnumType.STRING)
	Type type;
	
	
	@OneToMany(mappedBy ="stock", cascade = CascadeType.ALL)
	private List<Product> product = new ArrayList<>();
	
	public Stock() {
		super();
	}

	
	
	public Stock(int idStock, Long product_number, String stock_description, Type type) {
		super();
		this.idStock = idStock;
		this.product_number = product_number;
		this.stock_description = stock_description;
		this.type = type;
	}



	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public Long getProduct_number() {
		return product_number;
	}

	public void setProduct_number(Long product_number) {
		this.product_number = product_number;
	}

	public String getStock_description() {
		return stock_description;
	}

	public void setStock_description(String stock_description) {
		this.stock_description = stock_description;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
	
	
	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}




	public enum Type{
		MODE, INFORMATIQUE, ELECTRONIQUE, JEUXVIDEOS, SMARTPHONE, TABLETTE, MAISON, BUREAU, SANTE, BEAUTE, ARTICLE_SPORT, AUTO_MOTO, JARDIN_PLEIN_AIR, LIVRE 
	}


	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", product_number=" + product_number + ", stock_description="
				+ stock_description + ", type=" + type + "]";
	}

	

}
