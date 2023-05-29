package com.example.skunk.service;

 import com.example.skunk.model.DTO.CreateBrandFromJson;
import com.example.skunk.model.entity.Brand;
import com.example.skunk.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService{
    private final BrandRepository brandRepository;

    public List<Brand> createBrandFromJson(List<CreateBrandFromJson> createBrandFromJson) {
        List<Brand> brandList = createBrandFromJson.stream()
                .map(dto -> {
                    Brand brand = Brand.builder()
                            .name(dto.getFields().getName())
                            .build();
                    brandRepository.save(brand);
                    return brand;
                })
                .collect(Collectors.toList());
        return brandList;
    }
}
