package com.cv.services;

import com.cv.entities.Brand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class BrandServiceTest {
    @Autowired
    private BrandService brandService;

    @Test
    void testFetchingBrand() {
        List<Brand> brands = brandService.getAllBrands();

        log.info("result list {}", brands);

        Assertions.assertNotNull(brands);
    }
}
