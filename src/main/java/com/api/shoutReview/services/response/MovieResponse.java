package com.api.shoutReview.services.response;

import java.util.List;

import com.api.shoutReview.models.Genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponse {
	private String title;
    private Genre genre;
    private Double rating;
    private List<ReviewResponse> reviews;
}
