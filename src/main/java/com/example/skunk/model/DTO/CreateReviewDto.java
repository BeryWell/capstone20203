package com.example.skunk.model.DTO;

import com.example.skunk.model.entity.*;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateReviewDto {
    private PerfumeVitality perfumeVitality;
    private GenderExpressionScale genderExpressionScale;
    private Seasons seasons;
    private FashionStyle fashionStyle;
    private String description;
    private Long perfumeId;

    public Review toEntity(User user, Perfume perfume) {
        return Review.builder()
                .perfumeVitality(perfumeVitality)
                .genderExpressionScale(genderExpressionScale)
                .seasons(seasons)
                .fashionStyle(fashionStyle)
                .description(description)
                .writeUser(user)
                .perfume(perfume)
                .build();
    }
}
