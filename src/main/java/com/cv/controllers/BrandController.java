package com.cv.controllers;

import com.cv.dtos.BrandDTO;
import com.cv.entities.Brand;
import com.cv.services.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<?> addBrand(@RequestBody @Valid BrandDTO newBrand) {
        log.info("Received POST /brands | BrandDTO = {}", newBrand);

        Brand brand = brandService.insertBrand(newBrand);

        log.info("Responded POST /brands | brand = {}", brand);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @GetMapping
    public List<Brand> getAllBrands() {
        log.info("Received GET /brands");

        List<Brand> allBrands = brandService.getAllBrands();

        log.info("Responded GET /brands | allBrands = {}", allBrands);
        return allBrands;
    }

}
