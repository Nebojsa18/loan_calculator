/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nebojsa.loan_calculator.dto;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class InstallmentPlanDto {
    
    private double totalPayment;

    private double totalInterest;
    
    private LoanRequestDto loanRequest;
    
    private List<PlanItemDto> planItems;

    public InstallmentPlanDto() {
    }

    public InstallmentPlanDto(double totalPayment, double totalInterest, LoanRequestDto loanRequest, List<PlanItemDto> planItems) {
        this.totalPayment = totalPayment;
        this.totalInterest = totalInterest;
        this.loanRequest = loanRequest;
        this.planItems = planItems;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public LoanRequestDto getLoanRequest() {
        return loanRequest;
    }

    public void setLoanRequest(LoanRequestDto loanRequest) {
        this.loanRequest = loanRequest;
    }

    public List<PlanItemDto> getPlanItems() {
        return planItems;
    }

    public void setPlanItems(List<PlanItemDto> planItems) {
        this.planItems = planItems;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.totalPayment) ^ (Double.doubleToLongBits(this.totalPayment) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.totalInterest) ^ (Double.doubleToLongBits(this.totalInterest) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.loanRequest);
        hash = 89 * hash + Objects.hashCode(this.planItems);
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
        final InstallmentPlanDto other = (InstallmentPlanDto) obj;
        if (Double.doubleToLongBits(this.totalPayment) != Double.doubleToLongBits(other.totalPayment)) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalInterest) != Double.doubleToLongBits(other.totalInterest)) {
            return false;
        }
        if (!Objects.equals(this.loanRequest, other.loanRequest)) {
            return false;
        }
        return Objects.equals(this.planItems, other.planItems);
    }

    @Override
    public String toString() {
        return "InstallmentPlanDto{" + "totalPayment=" + totalPayment + ", totalInterest=" + totalInterest + ", loanRequest=" + loanRequest + ", planItems=" + planItems + '}';
    }

    
    
    
}
