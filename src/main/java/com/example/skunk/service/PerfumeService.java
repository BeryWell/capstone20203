package com.example.skunk.service;

import com.example.skunk.model.DTO.CreatePerfumeDto;
import com.example.skunk.model.entity.Perfume;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PerfumeService {
    Perfume create(CreatePerfumeDto createPerfumeDto);
    List<Perfume> getPerfumesByName(String name);
    ResponseEntity getPerfume(Long id);
}
