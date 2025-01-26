package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class BankStatement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long statementId;

    @NotNull(message = "Transaction date cannot be null")
    @FutureOrPresent(message = "Transaction date must be today or in the future")
    private LocalDate transactionDate;

    @Positive(message = "Amount must be greater than 0")
    private double amount;

    @NotBlank(message = "Description cannot be blank")
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    @NotBlank(message = "Category cannot be blank")
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User cannot be null")
    private User user;


	public BankStatement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankStatement(long statementId, LocalDate transactionDate, double amount, String description,
			String category, User user) {
		super();
		this.statementId = statementId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.description = description;
		this.category = category;
		this.user = user;
	}

	public long getStatementId() {
		return statementId;
	}

	public void setStatementId(long statementId) {
		this.statementId = statementId;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BankStatement [statementId=" + statementId + ", transactionDate=" + transactionDate + ", amount="
				+ amount + ", description=" + description + ", category=" + category + ", user=" + user + "]";
	}
	

}


