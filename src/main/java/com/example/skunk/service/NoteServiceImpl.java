package com.example.skunk.service;

import com.example.skunk.model.DTO.CreatesNoteFromJsonDto;
import com.example.skunk.model.entity.Note;
import com.example.skunk.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public void createNote(String name) {
        Note note = Note.builder()
                .name(name)
                .build();
        System.out.println(name);
        noteRepository.save(note);
    }

    @Override
    public Note findNote(String name) {
        Optional<Note> note = noteRepository.findByName(name);
        return note.get();
    }

    public List<String> createNotesFromJson(List<CreatesNoteFromJsonDto> createsNoteFromJsonDtoList) {
        List<String> noteNames = createsNoteFromJsonDtoList.stream()
                .map(dto -> dto.getFields().get("name"))
                .collect(Collectors.toList());
        System.out.println(noteNames);

        List<Note> notes = noteNames.stream()
                .map(name -> Note.builder().name(name).build())
                .collect(Collectors.toList());
        noteRepository.saveAll(notes);

        return noteNames;
    }
}
