package com.api.shoutReview.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.shoutReview.models.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {
	@Query(value = "select avg(rating) from review_table where movie_id=?",nativeQuery = true)
	Double getReviewAverage(Long id);

}
