package com.api.shoutReview.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.shoutReview.models.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long> {

}
