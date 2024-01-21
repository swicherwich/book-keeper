package com.bookkeeping.service.info.service;

import com.bookkeeping.service.info.model.LoanLog;
import com.bookkeeping.service.info.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<LoanLog> getAllLoans() {
        return loanRepository.findAll();
    }
}
