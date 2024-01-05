package com.api.shoutReview.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.shoutReview.models.Movie;
import com.api.shoutReview.models.Review;
import com.api.shoutReview.repos.MovieRepo;
import com.api.shoutReview.repos.ReviewRepo;
import com.api.shoutReview.services.response.ReviewResponse;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepo reviewRepo;

	@Autowired
	private MovieRepo movieRepo;

	public void addReview(Review review) {
		Movie movie = movieRepo.findById(review.getMovie().getId()).orElse(null);
		reviewRepo.save(review);
		if (movie != null) {
			Double average = reviewRepo.getReviewAverage(movie.getId());
			movie.setRating(average);
			movieRepo.save(movie);
		}

	}

	public ReviewResponse getReviewById(Long reviewId) {
		Optional<Review> review = reviewRepo.findById(reviewId);
		return review.map(Review::toReviewResponse).orElse(null);
	}

}
