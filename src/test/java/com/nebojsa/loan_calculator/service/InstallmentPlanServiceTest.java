/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nebojsa.loan_calculator.service;

import com.nebojsa.loan_calculator.model.InstallmentPlan;
import com.nebojsa.loan_calculator.model.LoanRequest;
import com.nebojsa.loan_calculator.model.PlanItem;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Admin
 */

public class InstallmentPlanServiceTest {
    
    private InstallmentPlanService installmentPlanService = new InstallmentPlanService();

    @Test
    void testCalculateInstallmentPlanFunction() {
        
        LoanRequest loanRequest=new LoanRequest();
        loanRequest.setAmount(10000.0);
        loanRequest.setInterestRate(5.0);
        loanRequest.setNum_of_months(5);
        
        double expectedTotalPayment = 10125.35;
        double expectedTotalInterest = 125.35;

        InstallmentPlan expectedPlan = new InstallmentPlan();
//        expectedPlan.setLoanRequest(loanRequest);
        expectedPlan.setTotalPayment(expectedTotalPayment);
        expectedPlan.setTotalInterest(expectedTotalInterest);
        
        List<PlanItem> expectedPlanItems = new ArrayList<>();
        expectedPlanItems.add(new PlanItem(1, 2025.07, 1983.40, 41.67, 8016.60));
        expectedPlanItems.add(new PlanItem(2, 2025.07, 1991.67, 33.40, 6024.93));
        expectedPlanItems.add(new PlanItem(3, 2025.07, 1999.97, 25.10, 4024.96));
        expectedPlanItems.add(new PlanItem(4, 2025.07, 2008.30, 16.77, 2016.66));
        expectedPlanItems.add(new PlanItem(5, 2025.06, 2016.66, 8.40, 0.00));
        
        expectedPlan.setPlanItems(expectedPlanItems);
        
        InstallmentPlan result = installmentPlanService.calculateInstallmentPlanFunction(loanRequest);
        
        assertNotNull(result);
        assertEquals(expectedTotalPayment, result.getTotalPayment(), 0.05,"Total payment isn't the same");
        assertEquals(expectedTotalInterest, result.getTotalInterest(), 0.05, "Total insterest isn't the same");

        for (int i = 0; i < result.getPlanItems().size(); i++) {
            PlanItem expected = expectedPlanItems.get(i);
            PlanItem actual = result.getPlanItems().get(i);
            assertEquals(expected.getMonth(), actual.getMonth(), "Month isn't the same");
            assertEquals(expected.getMonthlyPayment(), actual.getMonthlyPayment(), 0.05, "Monthly payment isn't the same!");
            assertEquals(expected.getPrincipalAmount(), actual.getPrincipalAmount(), 0.05, "Principal amount isn't the same!");
            assertEquals(expected.getInterestAmount(), actual.getInterestAmount(), 0.05, "Interest amount isn't the same!");
            assertEquals(expected.getRemainingAmount(), actual.getRemainingAmount(), 0.05, "Remaining amount isn't the same!");
        }

        
    }
    
}
