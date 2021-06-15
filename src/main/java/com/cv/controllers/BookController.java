package com.cv.controllers;

import com.cv.entities.Book;
import com.cv.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/upload")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("Received POST /upload");
        List<Book> books = bookService.saveData(file);
        log.info("Responded POST /upload | {}", books);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
