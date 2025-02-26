/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nebojsa.loan_calculator.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Admin
 */

@Entity
@Table(name="intallment_plan")
public class InstallmentPlan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="installement_plan_id")
    private long id;
    
    @Column(name="total_payment")
    private double totalPayment;
    @Column(name="total_interest")
    private double totalInterest;
    
    
    @OneToOne
    @JoinColumn(name="request_id")
    private LoanRequest loanRequest;
    
    @OneToMany(mappedBy="installmentPlan", cascade = CascadeType.ALL)
    private List<PlanItem> planItems;

    public InstallmentPlan() {
    }

    public InstallmentPlan(long id, double totalPayment, double totalInterest, LoanRequest loanRequest, List<PlanItem> planItems) {
        this.id = id;
        this.totalPayment = totalPayment;
        this.totalInterest = totalInterest;
        this.loanRequest = loanRequest;
        this.planItems = planItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LoanRequest getLoanRequest() {
        return loanRequest;
    }

    public void setLoanRequest(LoanRequest loanRequest) {
        this.loanRequest = loanRequest;
    }

    public List<PlanItem> getPlanItems() {
        return planItems;
    }

    public void setPlanItems(List<PlanItem> planItems) {
        this.planItems = planItems;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.totalPayment) ^ (Double.doubleToLongBits(this.totalPayment) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.totalInterest) ^ (Double.doubleToLongBits(this.totalInterest) >>> 32));
        hash = 19 * hash + Objects.hashCode(this.loanRequest);
        hash = 19 * hash + Objects.hashCode(this.planItems);
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
        final InstallmentPlan other = (InstallmentPlan) obj;
        if (this.id != other.id) {
            return false;
        }
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
        return "InstallmentPlan{" + "id=" + id + ", totalPayment=" + totalPayment + ", totalInterest=" + totalInterest + ", loanRequest=" + loanRequest + ", planItems=" + planItems + '}';
    }
    
    
    
    
}
