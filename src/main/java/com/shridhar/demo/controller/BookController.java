package com.shridhar.demo.controller;

import com.shridhar.demo.model.Book;
import com.shridhar.demo.model.BookList;
import com.shridhar.demo.repository.BookRepo;
import com.shridhar.demo.service.mongo.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private BookRepo bookRepo;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book) {
        bookRepo.save(book);
        return "Book added successfully";
    }

    @PostMapping("/addBookBulk")
    public String saveBookBulk(@RequestBody List<Book> books) {
        bookRepo.saveAll(books);
        return "Book added successfully";
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookRepo.deleteById(id);
        return String.format("Book with id '%s' deleted successfully", id);
    }

}
