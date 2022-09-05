package com.shridhar.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookList {

    @JsonProperty(value = "books")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
