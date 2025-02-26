/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nebojsa.loan_calculator.mapper;

import com.nebojsa.loan_calculator.dto.LoanRequestDto;
import com.nebojsa.loan_calculator.model.LoanRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Admin
 */
@Mapper(componentModel = "spring")
public interface LoanRequestMapper {
    LoanRequestMapper INSTANCE = Mappers.getMapper(LoanRequestMapper.class);
    
    LoanRequest toEntity(LoanRequestDto loanRequestDto);
    LoanRequestDto toDto(LoanRequest loanRequest);
    
    
}
