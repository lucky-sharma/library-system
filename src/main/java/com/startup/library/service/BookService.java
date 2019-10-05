package com.startup.library.service;

import com.startup.library.domain.Book;
import com.startup.library.domain.Category;
import com.startup.library.dto.BookDTO;
import com.startup.library.repository.BookRepository;
import com.startup.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    @Autowired
    CategoryRepository categoryRep;
    @Autowired
    BookRepository bookRepo;

    public String addBook(BookDTO bookDTO){
        Book bookDetail = bookRepo.findByBookName(bookDTO.getBookName());
        if (Objects.nonNull(bookDetail) && bookDetail
                .getBookName().equalsIgnoreCase(bookDTO.getBookName())){
            bookDetail.setTotalBooks(bookDetail.getTotalBooks()+1);
            bookDetail.setPrice(bookDTO.getPrice());
            Category category2 = bookDetail.getCategory();
            category2.setNoOfbooks(category2.getNoOfbooks()+1);
            categoryRep.save(category2);
            bookDetail.setCategory(category2);
            bookRepo.save(bookDetail);
            return bookDTO.toString();
        }else {
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
            book.setTotalBooks(bookRepo.countByBookName(bookDTO.getBookName()) + 1);
            bookRepo.save(book);
        }
        return bookDTO.toString();
    }

    public List<Book> getBookDetails(){
        List<Book> bookList = bookRepo.findAll();
        return bookList;
    }
}
