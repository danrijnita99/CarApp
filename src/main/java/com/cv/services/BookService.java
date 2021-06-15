package com.cv.services;

import com.cv.entities.Book;
import com.cv.helpers.ExcelUtils;
import com.cv.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> saveData(MultipartFile file) throws IOException {
        List<Book> books = ExcelUtils.xlsToList(file.getInputStream());
        return bookRepository.saveAll(books);
    }
}
