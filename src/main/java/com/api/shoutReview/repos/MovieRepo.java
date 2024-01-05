package com.api.shoutReview.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.shoutReview.models.Genre;
import com.api.shoutReview.models.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long> {
	public Movie findByTitle(String title);
	public List<Movie> findByGenre(Genre genre);
}
