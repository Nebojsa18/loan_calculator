/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nebojsa.loan_calculator.service;

import com.nebojsa.loan_calculator.dto.InstallmentPlanDto;
import com.nebojsa.loan_calculator.mapper.InstallmentPlanMapper;
import com.nebojsa.loan_calculator.model.InstallmentPlan;
import com.nebojsa.loan_calculator.model.LoanRequest;
import com.nebojsa.loan_calculator.model.PlanItem;
import com.nebojsa.loan_calculator.repository.InstallmentPlanRepository;
import com.nebojsa.loan_calculator.repository.PlanItemRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */

@Service
public class InstallmentPlanService {
    
    @Autowired
    private InstallmentPlanRepository installmentPlanRepository; 
    
//    @Autowired
//    private PlanItemRepository planItemRepository;
    
    @Autowired
    private InstallmentPlanMapper installmentPlanMapper;

    public InstallmentPlanDto calculateInstallmentPlan(LoanRequest loanRequest) {
        InstallmentPlan installmentPlan = calculateInstallmentPlanFunction(loanRequest);
        installmentPlanRepository.save(installmentPlan);
        return installmentPlanMapper.toDto(installmentPlan);
    }
    
    public InstallmentPlan calculateInstallmentPlanFunction(LoanRequest loanRequest) {

        BigDecimal amount = BigDecimal.valueOf(loanRequest.getAmount());
        BigDecimal interestRate = BigDecimal.valueOf(loanRequest.getInterestRate());
        int months = loanRequest.getNum_of_months();
        
        //interest/100/12
        BigDecimal monthlyRate = interestRate.divide(BigDecimal.valueOf(100 * 12), 10, RoundingMode.HALF_UP);
        // (1+monthlyRate)^months
        BigDecimal onePlusRatePow = BigDecimal.ONE.add(monthlyRate).pow(months);
        
        BigDecimal monthlyPayment = amount.multiply(monthlyRate)
                .multiply(onePlusRatePow)
                .divide(onePlusRatePow.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);
        // total=monthly*months
        BigDecimal totalPayment = monthlyPayment.multiply(BigDecimal.valueOf(months)).setScale(2, RoundingMode.HALF_UP);
        //totalInterest = totalPayment-amount
        BigDecimal totalInterest = totalPayment.subtract(amount).setScale(2, RoundingMode.HALF_UP);

        //setting values of installment plan
        InstallmentPlan installmentPlan = new InstallmentPlan();
        
        installmentPlan.setLoanRequest(loanRequest);
        installmentPlan.setTotalPayment(totalPayment.doubleValue());
        installmentPlan.setTotalInterest(totalInterest.doubleValue());

        List<PlanItem> planItems = new ArrayList<>();
        BigDecimal remainingBalance = amount;

        for (int i = 1; i <= months; i++) {
            //interest=remainingBallance*monthlyRate
            BigDecimal interest = remainingBalance.multiply(monthlyRate).setScale(2, RoundingMode.HALF_UP);
            //principal=remainingBalance-interest;
            BigDecimal principal = monthlyPayment.subtract(interest).setScale(2, RoundingMode.HALF_UP);
            //remainingBalance=remainingBalance-principal
            remainingBalance = remainingBalance.subtract(principal).setScale(2, RoundingMode.HALF_UP);

            PlanItem planItem = new PlanItem();
            planItem.setMonth(i);
            planItem.setInstallmentPlan(installmentPlan);
            planItem.setMonthlyPayment(monthlyPayment.doubleValue());
            planItem.setPrincipalAmount(principal.doubleValue());
            planItem.setInterestAmount(interest.doubleValue());
            planItem.setRemainingAmount(remainingBalance.doubleValue());

            planItems.add(planItem);
        }

        installmentPlan.setPlanItems(planItems);
        return installmentPlan;
    }
    
}
