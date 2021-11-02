package com.nagarro.salary.impl;

import com.nagarro.salary.EmployeeItem;
import com.nagarro.salary.SalaryCalculator;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Foy Lian
 * Date: 11/2/2021
 * Time: 2:47 PM
 */
public class FixSalaryCalculator implements SalaryCalculator {
    @Override
    public boolean support(Integer month, EmployeeItem item) {
        return "salary".equals(item.getType());
    }

    @Override
    public void calculate(Integer month, EmployeeItem item) {
        item.setSalary(item.getSalary().add(BigDecimal.valueOf(6000)));
    }
}
