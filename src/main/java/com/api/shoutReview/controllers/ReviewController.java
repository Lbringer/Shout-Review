package com.api.shoutReview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.shoutReview.services.ReviewService;
import com.api.shoutReview.services.request.ReviewRequest;
import com.api.shoutReview.services.response.ReviewResponse;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	@PostMapping("/add")
	public void addReview(@RequestBody ReviewRequest reviewRequest) {
		reviewService.addReview(reviewRequest.toReview());
	}
	
	@GetMapping("/find")
	public ReviewResponse getReview(@RequestParam Long reviewId) {
		return reviewService.getReviewById(reviewId);
	}
}
