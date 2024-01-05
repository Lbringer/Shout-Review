package com.api.shoutReview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.shoutReview.services.AdminService;
import com.api.shoutReview.services.request.MovieRequest;
import com.api.shoutReview.services.response.MovieResponse;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("movie/add")
	public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest){
		return new ResponseEntity<>(adminService.addMovie(movieRequest.toMovie()).toMovieResponse(),HttpStatus.CREATED);
	}
}
