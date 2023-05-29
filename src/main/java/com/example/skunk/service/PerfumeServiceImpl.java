package com.example.skunk.service;

import com.example.skunk.exception.NoteNotFoundException;
import com.example.skunk.model.DTO.CreatePerfumeDto;
import com.example.skunk.model.DTO.CreatePerfumeFromJsonDto;
import com.example.skunk.model.entity.Note;
import com.example.skunk.model.entity.Perfume;
import com.example.skunk.repository.BrandRepository;
import com.example.skunk.repository.NoteRepository;
import com.example.skunk.repository.PerfumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PerfumeServiceImpl implements PerfumeService {
    private final PerfumeRepository perfumeRepository;
    private final NoteRepository noteRepository;
    private final BrandRepository brandRepository;

    @Override
    public Perfume create(CreatePerfumeDto createPerfumeDto) {
        List<Note> topNote = createPerfumeDto.getTopNote()
                .stream()
                .map(s -> noteRepository.findByName(s)
                        .orElseThrow(() -> new NoteNotFoundException("Top Note not found: " + s)))
                .collect(Collectors.toList());
        List<Note> heartNote = createPerfumeDto.getHeartNote()
                .stream()
                .map(s -> noteRepository.findByName(s)
                        .orElseThrow(() -> new NoteNotFoundException("Heart Note not found: " + s)))
                .collect(Collectors.toList());
        List<Note> baseNote = createPerfumeDto.getBaseNote()
                .stream()
                .map(s -> noteRepository.findByName(s)
                        .orElseThrow(() -> new NoteNotFoundException("Base Note not found: " + s)))
                .collect(Collectors.toList());

        Perfume perfume = Perfume.builder()
                .name(createPerfumeDto.getName())
                .brand(createPerfumeDto.getBrand())
                .topNotes(topNote)
                .heartNotes(heartNote)
                .baseNotes(baseNote)
                .imgUrl(createPerfumeDto.getImgUrl())
                .build();

        perfumeRepository.save(perfume);
        return perfume;
    }

    @Override
    public List<Perfume> getPerfumesByName(String name) {
        System.out.println(name);
        return perfumeRepository.findAllByName(name);
    }

    @Override
    public Perfume getPerfume(Long id) {
        Optional<Perfume> perfume = perfumeRepository.findById(id);
        return perfume.get();
    }

    @Override
    public List<Perfume> createPerfumeFromJson(List<CreatePerfumeFromJsonDto> createPerfumeFromJsonDtoList) {
        List<Perfume> perfumeList = createPerfumeFromJsonDtoList.stream()
                .map(createPerfumeFromJsonDto -> {
                    List<Note> topNote = createPerfumeFromJsonDto.getFields().getTop_notes()
                            .stream()
                            .map(s -> noteRepository.findById(s)
                                    .orElseThrow(() -> new NoteNotFoundException("Note not found: " + s)))
                            .collect(Collectors.toList());
                    List<Note> heartNote = createPerfumeFromJsonDto.getFields().getHeart_notes()
                            .stream()
                            .map(s -> noteRepository.findById(s)
                                    .orElseThrow(() -> new NoteNotFoundException("Note not found: " + s)))
                            .collect(Collectors.toList());
                    List<Note> baseNote = createPerfumeFromJsonDto.getFields().getHeart_notes()
                            .stream()
                            .map(s -> noteRepository.findById(s)
                                    .orElseThrow(() -> new NoteNotFoundException("Note not found: " + s)))
                            .collect(Collectors.toList());

                    String brandName = brandRepository.findById(createPerfumeFromJsonDto.getFields().getBrand()).get().getName();

                    Perfume perfume = Perfume.builder()
                            .name(createPerfumeFromJsonDto.getFields().getName())
                            .brand(brandName)
                            .topNotes(topNote)
                            .heartNotes(heartNote)
                            .baseNotes(baseNote)
                            .imgUrl(createPerfumeFromJsonDto.getFields().getThumbnail())
                            .build();

                    perfumeRepository.save(perfume);
                    return perfume;
                })
                .collect(Collectors.toList());

        return perfumeList;

    }


    public List<Perfume> allPerfume() {
        return perfumeRepository.findAll();
    }


}
