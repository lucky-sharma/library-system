package com.startup.library.domain;
import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subjectCategory;
    private Long noOfbooks=0l;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(String subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public Long getNoOfbooks() {
        return noOfbooks;
    }

    public void setNoOfbooks(Long noOfbooks) {
        this.noOfbooks = noOfbooks;
    }
}
