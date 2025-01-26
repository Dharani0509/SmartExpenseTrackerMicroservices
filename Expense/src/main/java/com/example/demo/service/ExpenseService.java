package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Expense;

public interface ExpenseService {

    Expense saveExpense(Expense expense);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long expenseId);

    void deleteExpense(Long expenseId);

    List<Expense> getExpensesByUserId(Long userId);
}