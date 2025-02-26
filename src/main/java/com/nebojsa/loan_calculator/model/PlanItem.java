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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 *
 * @author Admin
 */

@Entity
@Table(name="intallment_plan_item")
public class PlanItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="plan_item_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="installement_plan_id")
    private InstallmentPlan installmentPlan;
    
    @Column(name="month")
    private int month;
    
    @Column(name="monthly_payment")
    private double monthlyPayment;
    
    @Column(name="principal_amount")
    private double principalAmount;
    
    @Column(name="interest_amount")
    private double interestAmount;
    
    @Column(name="remaining_amount")
    private double remainingAmount;

    public PlanItem() {
    }

    public PlanItem(Long id, InstallmentPlan installmentPlan, int month, double monthlyPayment, double principalAmount, double interestAmount, double remainingAmount) {
        this.id = id;
        this.installmentPlan = installmentPlan;
        this.month = month;
        this.monthlyPayment = monthlyPayment;
        this.principalAmount = principalAmount;
        this.interestAmount = interestAmount;
        this.remainingAmount = remainingAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstallmentPlan getInstallmentPlan() {
        return installmentPlan;
    }

    public void setInstallmentPlan(InstallmentPlan installmentPlan) {
        this.installmentPlan = installmentPlan;
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
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.installmentPlan);
        hash = 97 * hash + this.month;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.monthlyPayment) ^ (Double.doubleToLongBits(this.monthlyPayment) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.principalAmount) ^ (Double.doubleToLongBits(this.principalAmount) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.interestAmount) ^ (Double.doubleToLongBits(this.interestAmount) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.remainingAmount) ^ (Double.doubleToLongBits(this.remainingAmount) >>> 32));
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
        final PlanItem other = (PlanItem) obj;
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
        if (Double.doubleToLongBits(this.remainingAmount) != Double.doubleToLongBits(other.remainingAmount)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.installmentPlan, other.installmentPlan);
    }

    @Override
    public String toString() {
        return "PlanItem{" + "id=" + id + ", installmentPlan=" + installmentPlan + ", month=" + month + ", monthlyPayment=" + monthlyPayment + ", principalAmount=" + principalAmount + ", interestAmount=" + interestAmount + ", remainingAmount=" + remainingAmount + '}';
    }
    
    
    
}
