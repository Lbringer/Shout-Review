package com.api.shoutReview.services;

import org.springframework.stereotype.Service;

import com.api.shoutReview.models.Movie;
import com.api.shoutReview.repos.MovieRepo;

@Service
public class AdminService {
	
	private MovieRepo movieRepository;

    //constructor injection
    public AdminService(MovieRepo movieRepository) {
        this.movieRepository = movieRepository;
    }


	public Movie addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.save(movie);
	}

}
