package com.example.skunk.service;

import com.example.skunk.model.DTO.CreateReviewDto;
import com.example.skunk.model.entity.Review;
import com.example.skunk.model.entity.User;

import java.util.List;

public interface ReviewService {
    // create
    Review createReview(CreateReviewDto createReviewDto, User user);
    // getALL
    List<Review> getPerfumeReviews(Long noteId);
    // getOne
    Review getOneReview(Long id);
    // delete
    void deleteReview(Long id, User user);
}
