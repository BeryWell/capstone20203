package com.example.skunk.service;

import com.example.skunk.model.entity.Note;
import com.example.skunk.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService{
    private final NoteRepository noteRepository;
    @Override
    public void createNote(String name) {
        Note note = Note.builder()
                .name(name)
                .build();

        noteRepository.save(note);
    }

    @Override
    public Note findNote(String name) {
        Optional<Note> note = noteRepository.findByName(name);
        return note.get();
    }


}
