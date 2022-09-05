package com.shridhar.demo.repository;

import com.shridhar.demo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepo extends MongoRepository<Book, Integer> {
}
