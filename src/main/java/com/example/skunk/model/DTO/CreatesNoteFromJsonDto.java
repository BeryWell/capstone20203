package com.example.skunk.model.DTO;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class CreatesNoteFromJsonDto {
    private Long pk;
    private String model;
    private HashMap<String, String> fields;

    public String getName(){
        return fields.get("name");
    }
}
