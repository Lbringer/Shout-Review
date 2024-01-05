package com.api.shoutReview.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Movie {
	@Id
	@Column(name = "id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	//Average of all the review rating for this movie
	private Double rating;
	
	@OneToMany(mappedBy = "movie")
	private List<Review> reviews;
	
	//Response -> movie here
	
}
