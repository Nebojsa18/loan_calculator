/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nebojsa.loan_calculator.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


/**
 *
 * @author Admin
 */
public class LoanRequestDto {
    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be greater than 0")
    private double amount;
    
    @NotNull(message = "Interest rate is required")
    @Min(value = 1, message = "Interest rate must be greater than 0")
    private double interestRate;
    
    @NotNull(message = "Months are required")
    @Min(value = 1, message = "Number of months must be greater than 0")
    private int num_of_months;

    public LoanRequestDto() {
    }
    
    public LoanRequestDto(double amount, double interestRate, int num_of_months) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.num_of_months = num_of_months;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getNum_of_months() {
        return num_of_months;
    }

    public void setNum_of_months(int num_of_months) {
        this.num_of_months = num_of_months;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.interestRate) ^ (Double.doubleToLongBits(this.interestRate) >>> 32));
        hash = 61 * hash + this.num_of_months;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoanRequestDto other = (LoanRequestDto) obj;
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.interestRate) != Double.doubleToLongBits(other.interestRate)) {
            return false;
        }
        return this.num_of_months == other.num_of_months;
    }

    @Override
    public String toString() {
        return "LoanRequestDto{" + "amount=" + amount + ", interestRate=" + interestRate + ", num_of_months=" + num_of_months + '}';
    }
    
    
}
