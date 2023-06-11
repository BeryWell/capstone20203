package com.example.skunk.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Schema(description = "향수 리뷰")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"perfume"})
@EntityListeners(AuditingEntityListener.class)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "perfume_vitality")
    private PerfumeVitality perfumeVitality;

    @Column(name = "perfume_strength")
    private GenderExpressionScale genderExpressionScale;

    @Column(name = "perfume_season")
    private Seasons seasons;

    @Column(name = "perfume_style")
    private FashionStyle fashionStyle;

    @Column(name = "perfume_description")
    private String description;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonIgnoreProperties({
            "email",
            "password",
            "role",
            "authorities",
            "accountNonExpired",
            "accountNonLocked",
            "credentialsNonExpired",
            "enabled"})
    private User writeUser;

    @ManyToOne
    @JoinColumn(name = "perfume")
    private Perfume perfume;
}
