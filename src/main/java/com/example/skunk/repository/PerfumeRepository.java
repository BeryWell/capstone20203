package com.example.skunk.repository;

import com.example.skunk.model.entity.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
    @Query("SELECT p from Perfume p where p.name = :name")
    List<Perfume> findAllByName(@Param("name") String name);
    Optional<Perfume> findById(Long id);
}
