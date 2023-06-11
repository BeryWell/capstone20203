package com.example.skunk.controller;

import com.example.skunk.model.DTO.CreateReviewDto;
import com.example.skunk.model.entity.Review;
import com.example.skunk.model.entity.User;
import com.example.skunk.service.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewServiceImpl reviewService;
    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@AuthenticationPrincipal User user, @RequestBody CreateReviewDto createReviewDto){
        System.out.println(user);
        System.out.println(createReviewDto);
        Review review = reviewService.createReview(createReviewDto, user);
        return ResponseEntity.ok(review);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Review> getReview(@PathVariable Long id){
        Review review = reviewService.getOneReview(id);
        return ResponseEntity.ok(review);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Review> deleteReview(@AuthenticationPrincipal User user, @PathVariable Long id){
        reviewService.deleteReview(id, user);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/getall/{perfumeId}")
    public ResponseEntity<List<Review>> getPerfumeReview(@PathVariable Long perfumeId){
        List<Review> perfumeReviewList = reviewService.getPerfumeReviews(perfumeId);
        return ResponseEntity.ok(perfumeReviewList);
    }
}
