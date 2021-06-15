package com.cv.services;

import com.cv.dtos.BrandDTO;
import com.cv.entities.Brand;
import com.cv.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand insertBrand(BrandDTO newBrand) {
        Brand newCreatedBrand = Brand.builder()
                .name(newBrand.getName())
                .createdDate(new Date())
                .build();
        return brandRepository.save(newCreatedBrand);
    }

    public List<Brand> getAllBrands()  {
        return brandRepository.findAll();
    }

}
