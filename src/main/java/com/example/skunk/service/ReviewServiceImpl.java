package com.example.skunk.service;

import com.example.skunk.model.DTO.CreateReviewDto;
import com.example.skunk.model.entity.Perfume;
import com.example.skunk.model.entity.Review;
import com.example.skunk.model.entity.User;
import com.example.skunk.repository.PerfumeRepository;
import com.example.skunk.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final PerfumeRepository perfumeRepository;

    @Override
    public Review createReview(CreateReviewDto createReviewDto, User user) {
        Perfume perfume = perfumeRepository.findById(createReviewDto.getPerfumeId()).get();
        Review review = createReviewDto.toEntity(user, perfume);
        reviewRepository.save(review);
        return review;
    }

    @Override
    public List<Review> getPerfumeReviews(Long perfumeId) {
        Perfume perfume = perfumeRepository.findById(perfumeId)
                .orElseThrow(() -> new EntityNotFoundException("해당 향수가 존재하지 않습니다."));
        return reviewRepository.findAllByPerfume(perfume);
    }

    @Override
    public Review getOneReview(Long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public void deleteReview(Long id, User user) {
        Review review = reviewRepository.findById(id).get();
        if (review.getWriteUser().getUserId().equals(user.getUserId())) {
            reviewRepository.delete(review);
        } else {
            throw new IllegalArgumentException("해당 리뷰를 삭제할 권한이 없습니다.");
        }
    }
}
