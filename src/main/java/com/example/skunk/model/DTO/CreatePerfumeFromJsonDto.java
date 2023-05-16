package com.example.skunk.model.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreatePerfumeFromJsonDto {
    private Long pk;
    private String model;
    private PerfumeFromJsonDetailDto perfumeFromJsonDetailDto;
}
