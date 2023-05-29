package com.example.skunk.model.DTO;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CreatePerfumeFromJsonDto {
    private Long pk;
    private String model;
    private Fields fields;

    @Getter
    public static class Fields {
        private String name;
        private String launch_data;
        private String thumbnail;
        private Long gender;
        private List<Long> top_notes;
        private List<Long> heart_notes;
        private List<Long> base_notes;
        private List<Long> seasons;
        private boolean availability;
        private Long brand;
        private List<Long> categories;
        private Double price;
    }
}
