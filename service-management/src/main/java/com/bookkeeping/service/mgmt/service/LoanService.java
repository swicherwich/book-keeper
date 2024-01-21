package com.bookkeeping.service.mgmt.service;

import com.bookkeeping.service.mgmt.exception.BookUnavailableException;
import com.bookkeeping.service.mgmt.exception.LoanRefusedException;
import com.bookkeeping.service.mgmt.model.Book;
import com.bookkeeping.service.mgmt.model.LoanLog;
import com.bookkeeping.service.mgmt.model.LoanRequest;
import com.bookkeeping.service.mgmt.repository.BookRepository;
import com.bookkeeping.service.mgmt.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static java.lang.String.format;

@Service
public class LoanService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LoanRepository loanRepository;

    public LoanLog loanBook(String bookId, LoanRequest request) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new LoanRefusedException(format("Book with id '%s' does not exist", bookId)));

        if (!book.isAvailable()) {
            throw new BookUnavailableException(format("Book with id '%s' is unavailable.", bookId));
        }

        LoanLog loanLog = new LoanLog();
        book.setAvailable(false);
        loanLog.setBook(book);
        loanLog.setLoanStartDate(request.getStartDate());
        loanLog.setLoanEndDate(request.getExpectedEndDate());
        loanLog.setDetails(request.getDetails());

        return loanRepository.save(loanLog);
    }

    public LoanLog returnBook(String loanId) {
        LoanLog loanLog = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanRefusedException(format("No loan with such id: %s", loanId)));

        loanLog.setLoanReturned(true);
        loanLog.setLoanActualEndDate(LocalDate.now());
        loanLog.getBook().setAvailable(true);

        loanRepository.save(loanLog);
        return loanLog;
    }
}
