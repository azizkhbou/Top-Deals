package com.esprit.td.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.td.entities.Review;
import com.esprit.td.services.ReviewService;


@RestController
public class ReviewRestControlImpl {

	@Autowired
	ReviewService reviewService;
	
	
	@GetMapping(value="getAllReview")
	@ResponseBody
	public List<Review> getAllReviews(){
		return reviewService.retrieveAllReviews();
	}
	
/*	@PostMapping("/addReview")
	@ResponseBody
	public Review addReview(@RequestBody Review review) {
		reviewService.addReview(review);
		return review;
	}
*/	
	@DeleteMapping("/deleteReview/{review-id}")
	@ResponseBody
	public void deleteReview(@PathVariable("review-id") int reviewId) {
		reviewService.deleteReview(reviewId);
	}
}
