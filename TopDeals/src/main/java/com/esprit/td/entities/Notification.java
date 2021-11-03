package com.esprit.td.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.esprit.td.enums.Role;

import lombok.Data;
@Data
@Entity
@Table(name="T_Notification")

public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int idNotification;
	
	private String name;
	
	private String content;
	
	private Date dateNotif;
	
	@OneToOne
	private Deal deal;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List <User> users ;
	
	public Notification(int idNotification, String name, String content, Date dateNotif) {
		super();
		this.idNotification = idNotification;
		this.name = name;
		this.content = content;
		this.dateNotif = dateNotif;
	}

	
	
	
	
	

}
