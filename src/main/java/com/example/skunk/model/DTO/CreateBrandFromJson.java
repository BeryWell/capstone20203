package com.example.skunk.model.DTO;


import lombok.Getter;

import java.util.Map;

@Getter
public class CreateBrandFromJson {
    private Long pk;
    private String model;
    private Fields fields;


    @Getter
    public static class Fields {
        private String name;
        private String brand;


    }
}
