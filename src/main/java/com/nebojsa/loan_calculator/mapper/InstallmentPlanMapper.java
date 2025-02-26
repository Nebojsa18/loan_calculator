/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nebojsa.loan_calculator.mapper;

import com.nebojsa.loan_calculator.dto.InstallmentPlanDto;
import com.nebojsa.loan_calculator.model.InstallmentPlan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Admin
 */

@Mapper(componentModel = "spring", uses = {PlanItemMapper.class})
public interface InstallmentPlanMapper {
    
    InstallmentPlanMapper INSTANCE = Mappers.getMapper(InstallmentPlanMapper.class);

    InstallmentPlanDto toDto(InstallmentPlan installmentPlan);
    InstallmentPlan toEntity(InstallmentPlanDto installmentPlanDto);
}
