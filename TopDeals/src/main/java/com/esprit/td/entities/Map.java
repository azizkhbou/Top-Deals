package com.esprit.td.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
@Data
@Entity
@Table(name="T_Map")

public class Map {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMap;
	
	private String currentLocation;
	
	private String lastLocation;
	
	@OneToOne
	private User user;
	
	@ManyToOne
	private Deal deal;	
	
	public Map(int idMap, String currentLocation, String lastLocation) {
		super();
		this.idMap = idMap;
		this.currentLocation = currentLocation;
		this.lastLocation = lastLocation;
	}




}
