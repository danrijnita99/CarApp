package com.cv.helpers;

import com.cv.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelUtils {
    private static final String sheetName = "books";

    public static List<Book> xlsToList(InputStream inputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        List<Book> books = new ArrayList<>();

        for (Row row : sheet) {
            try {
                manageRow(row, books);
            } catch (Exception e) {
                log.info("Exception when parsing row={}", row, e);
            }
        }
        return books;
    }

    private static void manageRow(Row row, List<Book> books) {
        if (row.getRowNum() == 0) {
            return;
        }

        Book book = new Book();
        for (Cell cell : row) {
            switch (cell.getColumnIndex()) {
                case 0:
                    book.setId((long) cell.getNumericCellValue());
                    break;

                case 1:
                    book.setTitle(cell.getStringCellValue());
                    break;

                case 2:
                    book.setAuthor(cell.getStringCellValue());
                    break;

                case 3:
                    book.setPages((int) cell.getNumericCellValue());
                    break;

                case 4:
                    book.setPrice((int) cell.getNumericCellValue());
                    break;

                default:
                    break;
            }
        }
        books.add(book);
    }
}
