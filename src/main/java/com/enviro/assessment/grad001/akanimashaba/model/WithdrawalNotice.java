package com.enviro.assessment.grad001.akanimashaba.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "withdrawal_notices")
public class WithdrawalNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double withdrawalAmount;

    private LocalDate withdrawalDate;

    private String bankingDetails;
    @Column(name = "status")
    private String status; // "Pending", "Approved", "Processing", "Completed", "Rejected"

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(Double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public LocalDate getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(LocalDate withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public String getBankingDetails() {
        return bankingDetails;
    }

    public void setBankingDetails(String bankingDetails) {
        this.bankingDetails = bankingDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
