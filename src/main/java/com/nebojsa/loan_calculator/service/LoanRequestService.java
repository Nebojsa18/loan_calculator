/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nebojsa.loan_calculator.service;

import com.nebojsa.loan_calculator.dto.LoanRequestDto;
import com.nebojsa.loan_calculator.mapper.LoanRequestMapper;
import com.nebojsa.loan_calculator.model.LoanRequest;
import com.nebojsa.loan_calculator.repository.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */

@Service
public class LoanRequestService {
    
    @Autowired
    private LoanRequestRepository loanRequestRepository;
    @Autowired  
    private LoanRequestMapper loanRequestMapper;
    
    public LoanRequestDto createLoanRequest(LoanRequestDto loanRequestDto){
        LoanRequest loanRequest = loanRequestMapper.toEntity(loanRequestDto);
        
        
//        loanRequest = loanRequestRepository.save(loanRequest);
        return loanRequestMapper.toDto(loanRequest);
    }
    
}
