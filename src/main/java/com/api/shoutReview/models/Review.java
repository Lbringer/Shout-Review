package com.api.shoutReview.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.api.shoutReview.services.response.ReviewResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "review_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Review {
	
	@Id
	@Column(name = "id",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public String movieReview;
	
	//One rating for each review
	private double rating;
	
	@ManyToOne
	@JoinColumn(name = "movie_id",nullable = false)
	@JsonIgnore
	private Movie movie;
	
	@CreationTimestamp
	private Date createdDate;
	
	@UpdateTimestamp
	private Date updatedDate;
	
	public static ReviewResponse toReviewResponse(Review review) {
		return ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
	}

	public static List<ReviewResponse> toReviewResponse(List<Review> reviewList) {
		if(Objects.isNull(reviewList)) {
			return new ArrayList<>();
		}
		return reviewList.stream().map(Review :: toReviewResponse).toList();
	}
	
//	Review Response
}
