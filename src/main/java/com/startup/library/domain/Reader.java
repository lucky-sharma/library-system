package com.startup.library.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String mobileNumber;
    @OneToMany
    private List<BooksIsue> booksIsued;
    private Long noOfBooksIsued;
    private boolean isRemaining = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<BooksIsue> getBooksIsued() {
        return booksIsued;
    }

    public void setBooksIsued(List<BooksIsue> booksIsued) {
        this.booksIsued = booksIsued;
    }

    public Long getNoOfBooksIsued() {
        return noOfBooksIsued;
    }

    public void setNoOfBooksIsued(Long noOfBooksIsued) {
        this.noOfBooksIsued = noOfBooksIsued;
    }

    public boolean isRemaining() {
        return isRemaining;
    }

    public void setRemaining(boolean remaining) {
        isRemaining = remaining;
    }
}
