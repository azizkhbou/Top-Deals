package com.esprit.td.services.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.esprit.td.entities.Review;
import com.esprit.td.repositories.ReviewRepository;
import com.esprit.td.services.ReviewService;


@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewRepository reviewRepository;
	
	private static final Logger L = LogManager.getLogger(ReviewServiceImpl.class);
	
	
	@Override
    public List<Review> retrieveAllReviews() {
		// TODO Auto-generated method stub
		
		List<Review> reviews = (List<Review>) reviewRepository.findAll();
		
		for(Review review: reviews) {
			L.info("review :" +review); 
		}
		return reviews;
	}

/*	@Override
	public Review addReview(Review review) {
		// TODO Auto-generated method stub
		
		reviewRepository.save(review);
		return review;
	}
*/
/*	@Override
	public Review updateReview(Review review) {
		// TODO Auto-generated method stub
		
		
		//Review r = reviewRepository.findById(id).orElseThrow(null);
		
		Review newReview = new Review();
		
		newReview.setDescription(review.getDescription());
		newReview.setNote(review.getIdReview());
		L.info("Review :" + newReview);
		
		return newReview;
	}
*/
	@Override

	public Review retrieveReview(int id) {
		
		
		Review review = reviewRepository.findById(id).orElseThrow(null);
		L.info("Review" + review);
		return review;
	}

	@Override

	public void deleteReview(int id) {
		// TODO Auto-generated method stub
		
		Review review = reviewRepository.findById(id).orElseThrow(null);
		
		reviewRepository.delete(review);
		
	}

	@Override

	public int assignReview(Review review) {
		// TODO Auto-generated method stub
		
		reviewRepository.save(review);
		
		return review.getIdReview();
	}

	@Override

	public void modifyReview(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Review> ReviewsByProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
