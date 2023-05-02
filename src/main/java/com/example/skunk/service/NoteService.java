package com.example.skunk.service;

import com.example.skunk.model.entity.Note;

public interface NoteService {
    void createNote(String name);
    Note findNote(String name);
}
