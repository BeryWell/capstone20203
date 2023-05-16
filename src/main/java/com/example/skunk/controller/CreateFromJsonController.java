package com.example.skunk.controller;

import com.example.skunk.model.DTO.CreatesNoteFromJsonDto;
import com.example.skunk.model.entity.Note;
import com.example.skunk.service.BrandServiceImpl;
import com.example.skunk.service.NoteServiceImpl;
import com.example.skunk.service.PerfumeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity createBrands(){
        return null;
    }

    @PostMapping("/perfume")
    public ResponseEntity createPerfumes(){
        return null;
    }

}
