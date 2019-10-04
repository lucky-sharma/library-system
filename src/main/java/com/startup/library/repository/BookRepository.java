package com.startup.library.repository;

import com.startup.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    Long countByBookName(String bookName);
    Book findByBookName(String bookName);
}
