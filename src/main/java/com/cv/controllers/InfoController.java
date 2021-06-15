package com.cv.controllers;

import com.cv.dtos.Info;
import com.cv.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/posts")
public class InfoController {
    @Autowired
    private InfoService infoService;

    @GetMapping
    public ResponseEntity<?> getAllInfo() {
        Info[] infoList = infoService.getAllInfo();
        return new ResponseEntity<>(infoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInfo(@PathVariable Long id)  {
        Info info = infoService.getInfo(id);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
}
