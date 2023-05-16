package com.example.skunk.model.DTO;


import lombok.Getter;

import java.util.Map;

@Getter

public class CreateBrandFromJson {
    private Long pk;
    private String model;
    private Map<String, String> fields;

    public String getName(){
        return fields.get("name");
    }
}
