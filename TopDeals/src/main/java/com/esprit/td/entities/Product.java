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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="T_Product")


public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idP;
	
	private String name;
	
	private double price;
	
	private String url_product;
	
	@Enumerated(EnumType.STRING)
	Type type;
	
	
	@OneToMany(mappedBy ="product", cascade = CascadeType.ALL)
	private List<Review> review = new ArrayList<>();
	
	@ManyToOne
	Stock stock;
	
	@ManyToMany(mappedBy="products", cascade = CascadeType.ALL)
	private List<Deal> deals;
	
	public Product() {
		super();
	}

	

	public Product(String name, double price, String url_product, Type type) {
		super();
		this.name = name;
		this.price = price;
		this.url_product = url_product;
		this.type = type;
	}
	
	public Product(int idP, String name, double price, String url_product, Type type) {
		super();
		this.idP = idP;
		this.name = name;
		this.price = price;
		this.url_product = url_product;
		this.type = type;
	}



	public int getIdP() {
		return idP;
	}



	public void setIdP(int idP) {
		this.idP = idP;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getUrl_product() {
		return url_product;
	}



	public void setUrl_product(String url_product) {
		this.url_product = url_product;
	}



	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}


	

	public List<Review> getReview() {
		return review;
	}



	public void setReview(List<Review> review) {
		this.review = review;
	}




	@Override
	public String toString() {
		return "Product [idP=" + idP + ", name=" + name + ", price=" + price + ", url_product=" + url_product
				+ ", type=" + type + "]";
	}




	public enum Type{
		MODE, INFORMATIQUE, ELECTRONIQUE, JEUXVIDEOS, SMARTPHONE, TABLETTE, MAISON, BUREAU, SANTE, BEAUTE, ARTICLE_SPORT, AUTO_MOTO, JARDIN_PLEIN_AIR, LIVRE 
	}
}
