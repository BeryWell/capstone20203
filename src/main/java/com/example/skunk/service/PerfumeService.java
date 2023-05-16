package com.example.skunk.service;

import com.example.skunk.model.DTO.CreatePerfumeDto;
import com.example.skunk.model.DTO.CreatePerfumeFromJsonDto;
import com.example.skunk.model.entity.Perfume;

import java.util.List;

public interface PerfumeService {
    Perfume create(CreatePerfumeDto createPerfumeDto);
    List<Perfume> getPerfumesByName(String name);
    Perfume getPerfume(Long id);

    List<Perfume> createPerfumeFromJson(List<CreatePerfumeFromJsonDto> createPerfumeFromJsonDtoList);
}
