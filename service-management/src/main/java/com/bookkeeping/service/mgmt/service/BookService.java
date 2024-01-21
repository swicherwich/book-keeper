package com.bookkeeping.service.mgmt.service;

import com.bookkeeping.service.mgmt.model.Book;
import com.bookkeeping.service.mgmt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        throw new UnsupportedOperationException("not implemented");
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

}
