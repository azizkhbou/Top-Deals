package com.esprit.td.services;

import java.util.List;

import com.esprit.td.entities.Review;


public interface ReviewService {

	List<Review> retrieveAllReviews();
	
	
	public int assignReview(Review review);
	public void modifyReview(int id);
	public void deleteReview(int id);
	public Review retrieveReview(int id);
	public List<Review> ReviewsByProduct(int productId);
}
