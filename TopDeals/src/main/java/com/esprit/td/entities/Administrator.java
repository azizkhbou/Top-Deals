package com.esprit.td.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.esprit.td.enums.Role;

import lombok.Data;
@Data
@Entity
@Table(name="T_Administrator")

public class Administrator  extends Account{
	
	private String username;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;



}
