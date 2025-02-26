/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nebojsa.loan_calculator.repository;

import com.nebojsa.loan_calculator.model.PlanItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Admin
 */
public interface PlanItemRepository extends JpaRepository<PlanItem, Long>{
    
}
