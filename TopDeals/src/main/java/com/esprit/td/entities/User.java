package com.esprit.td.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.esprit.td.enums.Role;

import lombok.Data;
@Data
@Entity
@Table(name="T_User")

public class User extends Account {
	private String username;
	
	private String password;
	
	@Enumerated(EnumType.STRING)//bech yhothomli des string fel base moch int 
	private Role role;
	
	@OneToMany(mappedBy ="user", cascade = CascadeType.ALL)
	private List<Review> review = new ArrayList<>();
	
	@OneToOne(mappedBy="user")
	private Map map;
	
	@ManyToMany(mappedBy="users", cascade = CascadeType.ALL)
	private List<Notification> notifications;

	public User(String username, String password, Role role) {
		
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User() {
	}
	
	
	
	

}
