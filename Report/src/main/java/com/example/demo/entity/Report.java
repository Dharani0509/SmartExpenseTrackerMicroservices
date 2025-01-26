package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reportId;

    @NotBlank(message = "Date range cannot be blank")
    private String dateRange;

    @NotNull(message = "Total expense cannot be null")
    @Min(value = 0, message = "Total expense must be greater than or equal to 0")
    private double totalExpense;

    @NotBlank(message = "Category breakdown cannot be blank")
    @Column(columnDefinition = "TEXT")
    private String categoryBreakdown;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User cannot be null")
    private User user;
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(long reportId, String dateRange, double totalExpense, String categoryBreakdown, User user) {
		super();
		this.reportId = reportId;
		this.dateRange = dateRange;
		this.totalExpense = totalExpense;
		this.categoryBreakdown = categoryBreakdown;
		this.user = user;
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public double getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(double totalExpense) {
		this.totalExpense = totalExpense;
	}

	public String getCategoryBreakdown() {
		return categoryBreakdown;
	}

	public void setCategoryBreakdown(String categoryBreakdown) {
		this.categoryBreakdown = categoryBreakdown;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", dateRange=" + dateRange + ", totalExpense=" + totalExpense
				+ ", categoryBreakdown=" + categoryBreakdown + ", user=" + user + "]";
	}
	
	

}
