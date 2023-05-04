package com.example.skunk.controller;

import com.example.skunk.model.entity.Perfume;
import com.example.skunk.service.PerfumeService;
import com.example.skunk.service.PerfumeServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/perfume")
public class PerfumeController {
    private final PerfumeServiceImpl perfumeService;

//    @GetMapping("/getperfumes/{name}")
//    public List<Perfume> getPerfumes(@RequestParam String name){
//        List<Perfume> perfumes =  perfumeService.getPerfumesByName(name);
//        return perfumes;
//    }
    @GetMapping("/get_perfumes/{name}")
    public ResponseEntity<Map<String, Object>> getPerfumes(@RequestParam String name){
        List<Perfume> perfumes =  perfumeService.getPerfumesByName(name);

        Map<String, Object> result = new HashMap<>();
        result.put("data", perfumes);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
