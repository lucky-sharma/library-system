package com.startup.library.dto;

import javax.validation.constraints.NotEmpty;

public class BookDTO {
    @NotEmpty
    private String bookName;

    private String writerName;

    private String category;

    private Long price;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return bookName + "\n" + writerName + "\n" + category + "\n" + price;
    }
}
