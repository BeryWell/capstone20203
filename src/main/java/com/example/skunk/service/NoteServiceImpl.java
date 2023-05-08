package com.example.skunk.service;

import com.example.skunk.model.DTO.CreateNoteDto;
import com.example.skunk.model.DTO.CreatesNoteFromJsonDto;
import com.example.skunk.model.entity.Note;
import com.example.skunk.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public void createNote(CreateNoteDto createNoteDto) {
        Note note = Note.builder()
                .name(createNoteDto.getNote())
                .korName(createNoteDto.getKorName())
                .build();
        noteRepository.save(note);
    }

    @Override
    public Note findNote(String name) {
        Optional<Note> note = noteRepository.findByName(name);
        return note.get();
    }

    public List<Note> createNotesFromJson(List<CreatesNoteFromJsonDto> createsNoteFromJsonDtoList) {
        List<Note> notes = createsNoteFromJsonDtoList.stream()
                .map(dto -> {
                    Map<String, String> fields = dto.getFields();
                    String name = fields.get("name");
                    String korName = fields.get("kor_name");
                    return Note.builder()
                            .name(name)
                            .korName(korName)
                            .build();
                })
                .collect(Collectors.toList());

        noteRepository.saveAll(notes);

        return notes;
    }



}
