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
public class FetchingInfoTest {
    @Autowired
    RestTemplate restTemplate;

    String url = "https://jsonplaceholder.typicode.com/posts/1";

    @Test
    void testFetchingInfo() {
        ResponseEntity<Info> inf = restTemplate.getForEntity(url, Info.class);
        log.info("fetched info {}", inf);
        Assertions.assertNotNull(inf);
    }
}
