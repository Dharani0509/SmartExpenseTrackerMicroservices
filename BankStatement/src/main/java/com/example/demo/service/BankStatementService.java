package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.BankStatement;

public interface BankStatementService {

    // Service method to get all bank statements by user ID
    List<BankStatement> getBankStatementsByUserId(Long userId);
    
    // Service method to save a bank statement
    BankStatement saveBankStatement(BankStatement bankStatement);
}
