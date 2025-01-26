package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long budgetId;

    @NotBlank(message = "Category cannot be blank")
    private String category;

    @Positive(message = "Amount must be greater than 0")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User cannot be null")
    private User user;

	public Budget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Budget(long budgetId, String category, double amount, User user) {
		super();
		this.budgetId = budgetId;
		this.category = category;
		this.amount = amount;
		this.user = user;
	}

	public long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(long budgetId) {
		this.budgetId = budgetId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Budget [budgetId=" + budgetId + ", category=" + category + ", amount=" + amount + ", user=" + user
				+ "]";
	}	
	
}

