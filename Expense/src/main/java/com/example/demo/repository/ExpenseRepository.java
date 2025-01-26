package com.example.demo.repository;
import com.example.demo.entity.Expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Custom query to find expenses by userId
    @Query("SELECT e FROM Expense e WHERE e.user.userId = :userId")
    List<Expense> findAllByUserId(Long userId);
}
