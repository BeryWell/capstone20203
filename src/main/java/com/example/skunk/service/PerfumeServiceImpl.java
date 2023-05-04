package com.example.skunk.service;

import com.example.skunk.exception.NoteNotFoundException;
import com.example.skunk.model.DTO.CreatePerfumeDto;
import com.example.skunk.model.entity.Note;
import com.example.skunk.model.entity.Perfume;
import com.example.skunk.repository.NoteRepository;
import com.example.skunk.repository.PerfumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PerfumeServiceImpl implements PerfumeService {
    private final PerfumeRepository perfumeRepository;
    private final NoteRepository noteRepository;

    @Override
    public Perfume create(CreatePerfumeDto createPerfumeDto) {
        List<Note> topNote = createPerfumeDto.getTopNote()
                .stream()
                .map(s -> noteRepository.findByName(s)
                        .orElseThrow(() -> new NoteNotFoundException("Note not found: " + s)))
                .collect(Collectors.toList());
        List<Note> heartNote = createPerfumeDto.getHeartNote()
                .stream()
                .map(s -> noteRepository.findByName(s)
                        .orElseThrow(() -> new NoteNotFoundException("Note not found: " + s)))
                .collect(Collectors.toList());
        List<Note> baseNote = createPerfumeDto.getBaseNote()
                .stream()
                .map(s -> noteRepository.findByName(s)
                        .orElseThrow(() -> new NoteNotFoundException("Note not found: " + s)))
                .collect(Collectors.toList());

        Perfume perfume = Perfume.builder()
                .name(createPerfumeDto.getName())
                .brand(createPerfumeDto.getBrand())
                .topNotes(topNote)
                .heartNotes(heartNote)
                .baseNotes(baseNote)
                .build();

        perfumeRepository.save(perfume);
        return perfume;
    }

    @Override
    public List<Perfume> getPerfumesByName(String name) {
        List<Perfume> perfumes = perfumeRepository.findAllByName(name);
        return perfumes;
    }

    @Override
    public ResponseEntity getPerfume(Long id) {
        return null;
    }


}
