package com.example.skunk.service;

import com.example.skunk.model.DTO.CreateNoteDto;
import com.example.skunk.model.entity.Note;

public interface NoteService {
    void createNote(CreateNoteDto name);
    Note findNote(String name);
}
