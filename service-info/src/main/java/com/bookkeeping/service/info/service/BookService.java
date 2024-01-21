package com.bookkeeping.service.info.service;

import com.bookkeeping.service.info.model.Book;
import com.bookkeeping.service.info.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
