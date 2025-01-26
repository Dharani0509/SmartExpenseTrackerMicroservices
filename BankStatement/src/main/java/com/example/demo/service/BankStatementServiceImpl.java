package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BankStatement;
import com.example.demo.repository.BankStatementRepository;

@Service
public class BankStatementServiceImpl implements BankStatementService {

    @Autowired
    private BankStatementRepository bankStatementRepository;

    @Override
    public List<BankStatement> getBankStatementsByUserId(Long userId) {
        // Calling the repository method to fetch bank statements by user ID
        return bankStatementRepository.findAllByUser_UserId(userId);
    }

    @Override
    public BankStatement saveBankStatement(BankStatement bankStatement) {
        // Saving the bank statement to the database
        return bankStatementRepository.save(bankStatement);
    }
}

