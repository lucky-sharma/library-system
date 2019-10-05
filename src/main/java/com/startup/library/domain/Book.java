package com.startup.library.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String bookName;
    private String writerName;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    private boolean isAvailable = true;
    private Long totalBooks=0l;
    private Long price ;
    @Temporal(TemporalType.DATE)
    private Date addedDate = new Date();
    @Temporal(TemporalType.DATE)
    private Date deletedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Long getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(Long totalBooks) {
        this.totalBooks = totalBooks;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}