package com.nagarro.salary.impl;

import com.nagarro.salary.EmployeeItem;
import com.nagarro.salary.SalaryCalculator;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Foy Lian
 * Date: 11/2/2021
 * Time: 2:42 PM
 */
public class BirthdayCacluator implements SalaryCalculator {
    @Override
    public boolean support(Integer month, EmployeeItem item) {
        return true;
    }

    @Override
    public void calculate(Integer month, EmployeeItem item) {
        if(month.equals(Integer.parseInt(item.getBirthday().split("-")[1]))){
            item.setSalary(item.getSalary().add(BigDecimal.valueOf(100)));
        }
    }
}
