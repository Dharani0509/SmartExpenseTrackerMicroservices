package com.example.demo.controller;

import com.example.demo.entity.BankStatement;
import com.example.demo.service.BankStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-statements")
public class BankStatementController {

    @Autowired
    private BankStatementService bankStatementService;

    // Endpoint to get all bank statements for a specific user
    @GetMapping("/user/{userId}")
    public List<BankStatement> getBankStatementsByUserId(@PathVariable Long userId) {
        return bankStatementService.getBankStatementsByUserId(userId);
    }

    // Endpoint to save a new bank statement
    @PostMapping
    public BankStatement saveBankStatement(@RequestBody BankStatement bankStatement) {
        return bankStatementService.saveBankStatement(bankStatement);
    }
}

