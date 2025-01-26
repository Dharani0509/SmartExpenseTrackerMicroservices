package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BankStatement;

import java.util.List;

@Repository
public interface BankStatementRepository extends JpaRepository<BankStatement, Long> {

    // You can define custom methods to query BankStatements by User ID, for example:
    List<BankStatement> findAllByUser_UserId(Long userId);
}
