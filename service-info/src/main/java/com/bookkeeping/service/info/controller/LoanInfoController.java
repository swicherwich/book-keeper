package com.bookkeeping.service.info.controller;

import com.bookkeeping.service.info.model.LoanLog;
import com.bookkeeping.service.info.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/info/loan")
public class LoanInfoController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/all")
    public ResponseEntity<List<LoanLog>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }
}
