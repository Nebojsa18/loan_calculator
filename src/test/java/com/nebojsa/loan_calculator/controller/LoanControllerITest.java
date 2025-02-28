/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nebojsa.loan_calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nebojsa.loan_calculator.model.LoanRequest;
import com.nebojsa.loan_calculator.repository.LoanRequestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 *
 * @author Admin
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LoanControllerITest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private LoanRequestRepository loanRequestRepository;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    LoanRequest loanRequest;
  
    
    @Test
    public void calculateLoan() throws Exception{
    
        loanRequest=new LoanRequest();
        loanRequest.setAmount(10000.0);
        loanRequest.setInterestRate(5.0);
        loanRequest.setNum_of_months(10);
        
        mockMvc.perform(post("/loan-calculator/calculate")
            .content(objectMapper.writeValueAsString(loanRequest))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
        
    }
    
    @Test
    public void calculateLoan_with_InvalidArgument() throws Exception{
    
        loanRequest=new LoanRequest();
        //without ammount
        loanRequest.setInterestRate(5.0);
        loanRequest.setNum_of_months(10);
        
        mockMvc.perform(post("/loan-calculator/calculate")
            .content(objectMapper.writeValueAsString(loanRequest))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
        
    }
    
}
