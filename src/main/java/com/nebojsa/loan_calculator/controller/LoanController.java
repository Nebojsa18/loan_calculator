/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nebojsa.loan_calculator.controller;

import com.nebojsa.loan_calculator.dto.InstallmentPlanDto;
import com.nebojsa.loan_calculator.dto.LoanRequestDto;
import com.nebojsa.loan_calculator.model.LoanRequest;
import com.nebojsa.loan_calculator.service.InstallmentPlanService;
import com.nebojsa.loan_calculator.service.LoanRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


/**
 *
 * @author Admin
 */

@RestController
@RequestMapping("/loan-calculator")
public class LoanController {
    
    @Autowired
    private LoanRequestService loanRequestService;
    
    @Autowired
    private InstallmentPlanService installmentPlanService;
    
    
    @PostMapping("/calculate")
    public ResponseEntity<InstallmentPlanDto> calculateLoan(@Valid @RequestBody LoanRequestDto loanRequestDto) {
        LoanRequest createdLoanRequest = loanRequestService.createLoanRequest(loanRequestDto);
        
        InstallmentPlanDto installmentPlanDto = installmentPlanService.calculateInstallmentPlan(createdLoanRequest);
//        installmentPlanService.calculateInstallmentPlan(createdLoanRequest);
        return ResponseEntity.status(HttpStatus.OK).body(installmentPlanDto);
    }
}
