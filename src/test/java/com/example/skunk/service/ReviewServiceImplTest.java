package com.example.skunk.service;

import com.example.skunk.model.DTO.CreateReviewDto;
import com.example.skunk.model.entity.*;
import com.example.skunk.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewServiceImplTest {
    @Mock
    ReviewRepository reviewRepository;

    @InjectMocks
    ReviewServiceImpl reviewService;

    @Test
    void createReview() {
        // given
        User testUser = User.builder()
                .email("test email")
                .gender(Gender.MALE)
                .nickname("kong")
                .role(Role.USER)
                .build();

        CreateReviewDto createReviewDto = CreateReviewDto.builder()
                .perfumeVitality(PerfumeVitality.STRONG)
                .genderExpressionScale(GenderExpressionScale.NEUTRAL)
                .seasons(Seasons.FALL)
                .fashionStyle(FashionStyle.CASUAL)
                .description("description test")
//                .user(testUser)
                .build();
        // when
//        when(reviewRepository.save(createReviewDto.toEntity(testUser))).thenReturn(Review.builder()
//                .perfumeVitality(PerfumeVitality.STRONG)
//                .genderExpressionScale(GenderExpressionScale.NEUTRAL)
//                .seasons(Seasons.FALL)
//                .fashionStyle(FashionStyle.CASUAL)
//                .description("description test")
//                .writeUser(testUser)
//                .build());

        // then
        ArgumentCaptor<Review> argument = ArgumentCaptor.forClass(Review.class);

        verify(reviewRepository).save(argument.capture());
        assertEquals(PerfumeVitality.STRONG, argument.getValue().getPerfumeVitality());
        assertEquals(GenderExpressionScale.NEUTRAL, argument.getValue().getGenderExpressionScale());
        assertEquals(Seasons.FALL, argument.getValue().getSeasons());
        assertEquals(FashionStyle.CASUAL, argument.getValue().getFashionStyle());
        assertEquals("description test", argument.getValue().getDescription());
        assertEquals(testUser, argument.getValue().getWriteUser());
    }

    @Test
    void getAllReviews() {
    }

    @Test
    void getOneReview() {
    }

    @Test
    void deleteReview() {
    }
}