package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Budget;

public interface BudgetService {

    Budget saveBudget(Budget budget);

    List<Budget> getAllBudgets();

    Budget getBudgetById(Long budgetId);

    void deleteBudget(Long budgetId);
}
