package com.cv.services;

import com.cv.dtos.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InfoService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${url}")
    private String url;


    public Info getInfo(Long id) {
        ResponseEntity<Info> info = restTemplate.getForEntity(url + "/" + id, Info.class);
        return info.getBody();
    }

    public Info[] getAllInfo() {
        ResponseEntity<Info[]> infoList = restTemplate.getForEntity(url, Info[].class);
        return infoList.getBody();
    }
}
