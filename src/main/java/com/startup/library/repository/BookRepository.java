package com.startup.library.repository;

import com.startup.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b.totalBooks from Book b where LOWER(b.bookName)=LOWER(:bookName) and LOWER(b.writerName) = LOWER(:writerName) ")
    Long countByBookNameAndByWriterName(String bookName, String writerName);

    @Query(value = "select b from Book b where LOWER(b.bookName)=LOWER(:bookName) and LOWER(b.writerName) = LOWER(:writerName) ")
    Book findByBookNameAndByWriterName(String bookName, String writerName);
}
