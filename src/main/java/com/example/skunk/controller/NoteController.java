package com.example.skunk.controller;

import com.example.skunk.model.DTO.CreateNoteDto;
import com.example.skunk.model.DTO.CreatesNoteFromJsonDto;
import com.example.skunk.model.entity.Note;
import com.example.skunk.service.NoteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/note")
public class NoteController {
    private final NoteServiceImpl noteService;

    @Operation(summary = "Note Create", description = "노트 생성")
    @PostMapping("/create")
    public ResponseEntity createNote(@RequestBody CreateNoteDto createNoteDto) {
        System.out.println(createNoteDto.getNote());
        noteService.createNote(createNoteDto);
        return ResponseEntity.ok().body(createNoteDto.getNote());
    }
}
