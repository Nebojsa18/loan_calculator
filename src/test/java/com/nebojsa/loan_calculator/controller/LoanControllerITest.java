/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nebojsa.loan_calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nebojsa.loan_calculator.model.LoanRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
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
    private ObjectMapper objectMapper;
    
    LoanRequest loanRequest;
  
    
    @Test
    public void calculateLoan() throws Exception{
    
        loanRequest=new LoanRequest();
        loanRequest.setAmount(12330.0);
        loanRequest.setInterestRate(5.0);
        loanRequest.setNum_of_months(10);
        
        mockMvc.perform(post("/loan-calculator/calculate")
            .content(objectMapper.writeValueAsString(loanRequest))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.totalPayment").exists())
            .andExpect(jsonPath("$.totalInterest").exists())
            .andExpect(jsonPath("$.planItems").exists())
            .andExpect(jsonPath("$.planItems.length()").value(10));
        
    }
    
    @Test
    public void calculateLoan_with_InvalidArgument() throws Exception{
    
        loanRequest=new LoanRequest();
        //without ammount
//        loanRequest.setInterestRate(5.0);
//        loanRequest.setNum_of_months(10);
        
        mockMvc.perform(post("/loan-calculator/calculate")
            .content(objectMapper.writeValueAsString(loanRequest))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.amount").value("Amount must be greater than 0"))
            .andExpect(jsonPath("$.num_of_months").value("Number of months must be greater than 0"))
            .andExpect(jsonPath("$.interestRate").value("Interest rate must be greater than 0"));
        
    }
    
}
