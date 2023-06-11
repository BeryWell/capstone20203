package com.example.skunk.controller;

import com.example.skunk.model.DTO.CreatePerfumeDto;
import com.example.skunk.model.entity.Perfume;
import com.example.skunk.service.PerfumeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "향수", description = "향수 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/perfume")
public class PerfumeController {
    private final PerfumeServiceImpl perfumeService;


    @Operation(summary = "향수 이름으로 가져오기", description = "향수 이름으로 전부 가져오기\n" +
            "List형으로 Json을 보내드립니다.")
    @GetMapping("/get_perfumes")
    public ResponseEntity<Map<String, Object>> getPerfumes(@Parameter(description = "이름", required = true, example = "Blackberry & Bay Cologne") @RequestParam("name") String name){
        List<Perfume> perfumes = perfumeService.getPerfumesByName(name);
        Map<String, Object> result = new HashMap<>();
        result.put("data", perfumes);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "향수 생성", description = "향수 DB에 Create")
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody CreatePerfumeDto createPerfumeDto){
        perfumeService.create(createPerfumeDto);
        return ResponseEntity.ok().body(createPerfumeDto);
    }
    @Operation(summary = "향수 전부 가져오기", description = "향수 DB에 있는 값들 전부 가져오기")
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
