package com.esprit.td.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name="T_Review")

public class Review implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReview;
	
	private int note;
	
	private String description;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private User user;
	
	public Review() {
		super();
	}

	public Review(int idReview, int note, String description) {
		super();
		this.idReview = idReview;
		this.note = note;
		this.description = description;
	}
	

	public Review(int note, String description) {
		super();
		this.note = note;
		this.description = description;
	}

	public int getIdReview() {
		return idReview;
	}

	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Review [idReview=" + idReview + ", note=" + note + ", description=" + description + "]";
	}
	
	
	
	
	
	

}
