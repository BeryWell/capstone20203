package com.example.skunk.controller;

import com.example.skunk.model.DTO.CreateBrandFromJson;
import com.example.skunk.model.DTO.CreatePerfumeDto;
import com.example.skunk.model.DTO.CreatePerfumeFromJsonDto;
import com.example.skunk.model.DTO.CreatesNoteFromJsonDto;
import com.example.skunk.model.entity.Brand;
import com.example.skunk.model.entity.Note;
import com.example.skunk.model.entity.Perfume;
import com.example.skunk.service.BrandServiceImpl;
import com.example.skunk.service.NoteServiceImpl;
import com.example.skunk.service.PerfumeServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/create/json")
public class CreateFromJsonController {
    private final NoteServiceImpl noteService;
    private final PerfumeServiceImpl perfumeService;
    private final BrandServiceImpl brandService;

    @PostMapping("/note")
    public ResponseEntity createNotes(@RequestBody List<CreatesNoteFromJsonDto> createsNoteDto) {
        List<Note> notes = noteService.createNotesFromJson(createsNoteDto);
        return ResponseEntity.ok().body(notes);
    }

    @PostMapping("/brand")
    public ResponseEntity createBrands(@RequestBody List<CreateBrandFromJson> createBrandFromJsonList){
        List<Brand> brands = brandService.createBrandFromJson(createBrandFromJsonList);
        return ResponseEntity.ok().body(brands);
    }

    @PostMapping("/perfume")
    public ResponseEntity createPerfumes(@RequestBody List<CreatePerfumeFromJsonDto> createPerfumeFromJsonDtoList){
        List<Perfume> perfumes = perfumeService.createPerfumeFromJson(createPerfumeFromJsonDtoList);
        return ResponseEntity.ok().body(perfumes);
    }

}
