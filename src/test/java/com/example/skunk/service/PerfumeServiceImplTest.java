package com.example.skunk.service;

import com.example.skunk.model.DTO.CreatePerfumeDto;
import com.example.skunk.model.entity.Note;
import com.example.skunk.model.entity.Perfume;
import com.example.skunk.repository.NoteRepository;
import com.example.skunk.repository.PerfumeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PerfumeServiceImplTest {
    @Mock
    PerfumeRepository perfumeRepository;
    @Mock
    NoteRepository noteRepository;
    @InjectMocks
    PerfumeServiceImpl perfumeService;

    @Test
    void create() {
        // given
        CreatePerfumeDto createPerfumeDto = CreatePerfumeDto.builder()
                .name("Test Perfume")
                .brand("Test Brand")
                .topNote(Arrays.asList("Top Note 1", "Top Note 2"))
                .heartNote(Arrays.asList("Heart Note 1", "Heart Note 2"))
                .baseNote(Arrays.asList("Base Note 1", "Base Note 2"))
                .build();

        when(noteRepository.findByName(anyString())).thenAnswer(invocation -> {
            String noteName = invocation.getArgument(0);
            Note note = new Note();
            note.setName(noteName);
            return Optional.of(note);
        });


        ArgumentCaptor<Perfume> argument = ArgumentCaptor.forClass(Perfume.class);

        // when
        perfumeService.create(createPerfumeDto);

        // then
        verify(perfumeRepository).save(argument.capture());
        assertEquals("Test Perfume", argument.getValue().getName());
        assertEquals("Test Brand", argument.getValue().getBrand());
        assertEquals(2, argument.getValue().getTopNotes().size());
        assertEquals(2, argument.getValue().getHeartNotes().size());
        assertEquals(2, argument.getValue().getBaseNotes().size());
    }
}