/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nebojsa.loan_calculator.mapper;

import com.nebojsa.loan_calculator.dto.PlanItemDto;
import com.nebojsa.loan_calculator.model.PlanItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Admin
 */
@Mapper(componentModel = "spring")
public interface PlanItemMapper {
    PlanItemMapper INSTANCE = Mappers.getMapper(PlanItemMapper.class);

    PlanItemDto toDto(PlanItem planItem);
    PlanItem toEntity(PlanItemDto planItemDto);
}