package com.esprit.td.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="T_Deal")
public class Deal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDeal;
	
	private String description;
	
	private Date expirationDate;
	
	private String productName;
	
	private int dealPrice;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List <Product> products ;
	
	
	@OneToOne(mappedBy="deal")
	private Notification notification;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="deal")
	private List<Map> DealMap;
	
	public Deal(int idDeal, String description, Date expirationDate, String productName, int dealPrice) {
		super();
		this.idDeal = idDeal;
		this.description = description;
		this.expirationDate = expirationDate;
		this.productName = productName;
		this.dealPrice = dealPrice;
	}

	public Deal() {
	
	}
	


	
	

}