package com.startup.library.controller;

import com.startup.library.domain.Book;
import com.startup.library.dto.BookDTO;
import com.startup.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/add/book", method = RequestMethod.POST)
    public ResponseEntity<Object> addBook(@RequestBody BookDTO bookDTO) {
        String bookDTO1 = bookService.addBook(bookDTO);
        if (Objects.nonNull(bookDTO1)) {
            return new ResponseEntity<Object>(bookDTO1, HttpStatus.OK);
        }
        return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/book/list", method = RequestMethod.GET)
    public ResponseEntity<Object> getBookDetails() {
        List<Book> bookList = bookService.getBookDetails();
        if (Objects.nonNull(bookList))
            return new ResponseEntity<Object>(bookList, HttpStatus.OK);
        return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ResponseEntity<Object> getBookDetailByName(@RequestParam String book, @RequestParam String writer) {
        Book bookdetail = bookService.getBookDetailsByBookName(book, writer);
        if (Objects.nonNull(bookdetail)) {
            return new ResponseEntity<>(bookdetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}