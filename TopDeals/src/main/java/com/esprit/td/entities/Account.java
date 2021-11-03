package com.esprit.td.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Inheritance (strategy = InheritanceType.JOINED)

@Table(name="T_Account")

public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique = true)
	private String email;
	
	private String adress;


	
	

}