package com.example.skunk.controller;

import com.example.skunk.model.DTO.CreateNoteDto;
import com.example.skunk.service.NoteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/note")
public class NoteController {
    private final NoteServiceImpl noteService;

    @PostMapping("/create")
    public ResponseEntity createNote(@RequestBody CreateNoteDto createNoteDto){
        System.out.println(createNoteDto.getNote());
        noteService.createNote(createNoteDto.getNote());
        return ResponseEntity.ok().body(createNoteDto.getNote());
    }
}
