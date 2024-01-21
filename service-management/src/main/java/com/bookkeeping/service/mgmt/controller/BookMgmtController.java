package com.bookkeeping.service.mgmt.controller;

import com.bookkeeping.service.mgmt.model.Book;
import com.bookkeeping.service.mgmt.model.LoanLog;
import com.bookkeeping.service.mgmt.model.LoanRequest;
import com.bookkeeping.service.mgmt.service.BookService;
import com.bookkeeping.service.mgmt.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mgmt")
public class BookMgmtController {

    @Autowired
    private BookService bookService;

    @Autowired
    private LoanService loanService;

    @PostMapping("/book")
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        Book bookWithId = bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookWithId);
    }

    @PatchMapping("book/{id}")
    public ResponseEntity<?> editBookInfo(@RequestBody Book book, @PathVariable("id") String id) {
        book.setId(id);
        Book bookWithId = bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(bookWithId);
    }

    @DeleteMapping("/book")
    public ResponseEntity<?> deleteBook(@RequestBody Book book) {
        bookService.deleteBook(book);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/book/{id}/loan")
    public ResponseEntity<?> loanBook(@PathVariable("id") String id, @RequestBody LoanRequest loanRequest) {
        LoanLog loanLog = loanService.loanBook(id, loanRequest);
        return ResponseEntity.accepted().body(loanLog);
    }

    @PostMapping("book/{id}/return")
    public ResponseEntity<?> returnBook(@PathVariable("id") String id) {
        LoanLog loanLog = loanService.returnBook(id);
        return ResponseEntity.ok(loanLog);
    }
}
