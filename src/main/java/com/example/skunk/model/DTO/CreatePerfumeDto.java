package com.example.skunk.model.DTO;

import com.example.skunk.model.entity.Note;
import com.example.skunk.model.entity.Perfume;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CreatePerfumeDto {
    private String name;
    private String brand;

    private List<String> topNote;
    private List<String> heartNote;
    private List<String> baseNote;
    private String imgUrl;
     public Perfume toPerfume(){
         return Perfume.builder()
                 .name(name)
                 .brand(brand)
                 .imgUrl(imgUrl)
                 .build();
     }
}
