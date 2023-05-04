package com.example.skunk.model.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class CreateNoteDto {
    private String note;
}
