package com.api.shoutReview.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.shoutReview.models.Genre;
import com.api.shoutReview.models.Movie;
import com.api.shoutReview.repos.MovieRepo;
import com.api.shoutReview.services.response.MovieResponse;

@Service
public class MovieService {
	@Autowired
	private MovieRepo movieRepo;

	public MovieResponse findMovie(String title) {
		Movie movie = movieRepo.findByTitle(title);
		if (Objects.nonNull(movie)) {
			return movie.toMovieResponse();
		}
		return null;
	}

	public List<MovieResponse> findMoviesByGenre(String genre) {
		if (Arrays.stream(Genre.values()).noneMatch(g -> g.toString().equals(genre))) {
			return new ArrayList<>();
		}
		List<Movie> movieList = movieRepo.findByGenre(Genre.valueOf(genre));
		if (!movieList.isEmpty()) {
			List<MovieResponse> movieResponseList = movieList.stream()
					.sorted(Comparator.comparing(Movie::getRating, Comparator.reverseOrder()))
					.map(m -> m.toMovieResponse()).toList();
			if (movieResponseList.size() > 5)
                return movieResponseList.subList(0, 4);
            return movieResponseList;
		}
		return new ArrayList<>();
	}

}
