package com.api.shoutReview.services.request;

import com.api.shoutReview.models.Movie;
import com.api.shoutReview.models.Review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
	private String movieReview;
	private double rating;
	private Long movieId;

	public Review toReview() {
		// TODO Auto-generated method stub
		return Review.builder().movieReview(movieReview).rating(rating).
				movie(Movie.builder().id(movieId).build())
				.build();
	}

}
