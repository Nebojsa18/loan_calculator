/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nebojsa.loan_calculator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Admin
 */

@Entity
@Table(name="loan_request")
public class LoanRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="request_id")
    private long id;
    
    @Column(name="amount")
    private double amount;
    
    @Column(name="interest_rate")
    private double interestRate;
    
    @Column(name="num_of_months")
    private int num_of_months;

    public LoanRequest() {
    }
    
    
    public LoanRequest(long id, double amount, double interestRate, int num_of_months) {
        this.id = id;
        this.amount = amount;
        this.interestRate = interestRate;
        this.num_of_months = num_of_months;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getNum_of_months() {
        return num_of_months;
    }

    
    
    public void setId(long id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setNum_of_months(int num_of_months) {
        this.num_of_months = num_of_months;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.interestRate) ^ (Double.doubleToLongBits(this.interestRate) >>> 32));
        hash = 47 * hash + this.num_of_months;
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
        final LoanRequest other = (LoanRequest) obj;
        if (this.id != other.id) {
            return false;
        }
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
        return "LoanRequest{" + "id=" + id + ", amount=" + amount + ", interestRate=" + interestRate + ", num_of_months=" + num_of_months + '}';
    }
    
    
    
}
