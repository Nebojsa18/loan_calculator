/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nebojsa.loan_calculator.dto;

/**
 *
 * @author Admin
 */
public class PlanItemDto {
    
    
    private int month;
    private double monthlyPayment;
    private double principalAmount;
    private double interestAmount;
    private double remainingAmount;

    public PlanItemDto() {
    }

    public PlanItemDto(int month, double monthlyPayment, double principalAmount, double interestAmount, double remainingAmount) {
        this.month = month;
        this.monthlyPayment = monthlyPayment;
        this.principalAmount = principalAmount;
        this.interestAmount = interestAmount;
        this.remainingAmount = remainingAmount;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(double interestAmount) {
        this.interestAmount = interestAmount;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.month;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.monthlyPayment) ^ (Double.doubleToLongBits(this.monthlyPayment) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.principalAmount) ^ (Double.doubleToLongBits(this.principalAmount) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.interestAmount) ^ (Double.doubleToLongBits(this.interestAmount) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.remainingAmount) ^ (Double.doubleToLongBits(this.remainingAmount) >>> 32));
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
        final PlanItemDto other = (PlanItemDto) obj;
        if (this.month != other.month) {
            return false;
        }
        if (Double.doubleToLongBits(this.monthlyPayment) != Double.doubleToLongBits(other.monthlyPayment)) {
            return false;
        }
        if (Double.doubleToLongBits(this.principalAmount) != Double.doubleToLongBits(other.principalAmount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.interestAmount) != Double.doubleToLongBits(other.interestAmount)) {
            return false;
        }
        return Double.doubleToLongBits(this.remainingAmount) == Double.doubleToLongBits(other.remainingAmount);
    }

    @Override
    public String toString() {
        return "PlanItemDto{" + "month=" + month + ", monthlyPayment=" + monthlyPayment + ", principalAmount=" + principalAmount + ", interestAmount=" + interestAmount + ", remainingAmount=" + remainingAmount + '}';
    }
    
    
}
