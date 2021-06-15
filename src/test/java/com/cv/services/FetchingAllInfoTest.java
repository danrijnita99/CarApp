package com.cv.services;

import com.cv.dtos.Info;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootTest
public class FetchingAllInfoTest {
    @Autowired
    RestTemplate restTemplate;
    String url = "https://jsonplaceholder.typicode.com/posts";

    @Test
    void fetchingAllInfo() {
        ResponseEntity<Info[]> infoList = restTemplate.getForEntity(url, Info[].class);
        log.info("fetched info {}", infoList);
        Assertions.assertNotNull(infoList);
    }

}
