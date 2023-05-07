package com.example.skunk.controller;

import com.example.skunk.model.DTO.CreatePerfumeDto;
import com.example.skunk.model.entity.Perfume;
import com.example.skunk.service.PerfumeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/perfume")
public class PerfumeController {
    private final PerfumeServiceImpl perfumeService;

    @GetMapping("/get_perfumes")
    public ResponseEntity<Map<String, Object>> getPerfumes(@RequestParam("name") String name){
        List<Perfume> perfumes = perfumeService.getPerfumesByName(name);
        System.out.println(perfumes);
        Map<String, Object> result = new HashMap<>();
        result.put("data", perfumes);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody CreatePerfumeDto createPerfumeDto){
        perfumeService.create(createPerfumeDto);
        return ResponseEntity.ok().body(createPerfumeDto);
    }
    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        List<Perfume> allPerfume = perfumeService.allPerfume();
        return ResponseEntity.ok().body(allPerfume);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
