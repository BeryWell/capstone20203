package com.example.skunk.repository;

import com.example.skunk.model.entity.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
    List<Perfume> findAllByName(String name);
}
