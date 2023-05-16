package com.example.skunk.service;

import com.example.skunk.model.DTO.CreateBrandDto;
import com.example.skunk.model.DTO.CreateBrandFromJson;
import com.example.skunk.model.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> createBrandFromJson(List<CreateBrandFromJson> createBrandFromJson);
}
