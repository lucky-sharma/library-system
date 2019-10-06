package com.startup.library.service;

import com.startup.library.domain.Book;
import com.startup.library.domain.Category;
import com.startup.library.dto.BookDTO;
import com.startup.library.repository.BookRepository;
import com.startup.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    @Autowired
    CategoryRepository categoryRep;
    @Autowired
    BookRepository bookRepo;

    @Transactional
    public String addBook(BookDTO bookDTO) {
        Book bookDetail = bookRepo.findByBookNameAndByWriterName(bookDTO.getBookName(), bookDTO.getWriterName());
        if (Objects.nonNull(bookDetail)) {
            bookDetail.setTotalBooks(bookDetail.getTotalBooks() + 1);
            bookDetail.setPrice(bookDTO.getPrice());
            Category category = bookDetail.getCategory();
            category.setNoOfbooks(category.getNoOfbooks() + 1);
            categoryRep.save(category);
            bookDetail.setCategory(category);
            bookRepo.save(bookDetail);
            return bookDTO.toString();
        } else {
            Book book = new Book();
            book.setBookName(bookDTO.getBookName());
            book.setWriterName(bookDTO.getWriterName());
            Category category = categoryRep.findBySubjectCategory(bookDTO.getCategory());
            if (Objects.isNull(category)) {
                Category category1 = new Category();
                category1.setSubjectCategory(bookDTO.getCategory());
                category1.setNoOfbooks(category1.getNoOfbooks() + 1);
                categoryRep.save(category1);
                book.setCategory(category1);
            } else {
                category.setNoOfbooks(category.getNoOfbooks() + 1);
                categoryRep.save(category);
                book.setCategory(category);
            }
            book.setPrice(bookDTO.getPrice());
            book.setTotalBooks(book.getTotalBooks() + 1);
            bookRepo.save(book);
        }
        return bookDTO.toString();
    }

    public List<Book> getBookDetails() {
        List<Book> bookList = bookRepo.findAll();
        return bookList;
    }

    public Book getBookDetailsByBookName(String bookName, String WriterName) {
        Book book = bookRepo.findByBookNameAndByWriterName(bookName, WriterName);
        return book;
    }
}
