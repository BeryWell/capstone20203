package com.example.skunk.service;

import com.example.skunk.model.DTO.CreateNoteDto;
import com.example.skunk.model.DTO.CreatesNoteFromJsonDto;
import com.example.skunk.model.entity.Note;

import java.util.List;

public interface NoteService {
    void createNote(CreateNoteDto name);
    Note findNote(String name);
    List<Note> createNotesFromJson(List<CreatesNoteFromJsonDto> createsNoteFromJsonDtoList);
}
