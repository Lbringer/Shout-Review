package com.api.shoutReview.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.shoutReview.models.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {

}
