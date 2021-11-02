package com.nagarro.salary.impl;

import com.nagarro.salary.EmployeeItem;
import com.nagarro.salary.SalaryCalculator;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Foy Lian
 * Date: 11/2/2021
 * Time: 2:49 PM
 */
public class HourCalculator implements SalaryCalculator {
    @Override
    public boolean support(Integer month, EmployeeItem item) {
        return "hour".equals(item.getType());
    }

    @Override
    public void calculate(Integer month, EmployeeItem item) {
        BigDecimal baseWorkingHours = BigDecimal.valueOf(160);
        BigDecimal baseHourlyRate = BigDecimal.valueOf(35);
        if (item.getWorkingHours().compareTo(baseWorkingHours) < 1) {
            BigDecimal salary = baseHourlyRate.multiply(item.getWorkingHours());
            item.setSalary(salary);
            return;
        }
        BigDecimal baseSalary = baseWorkingHours.multiply(baseHourlyRate);
        BigDecimal extraSalary = item.getWorkingHours().subtract(baseWorkingHours).multiply(baseHourlyRate).multiply(BigDecimal.valueOf(1.3));
        item.setSalary(baseSalary.add(extraSalary));
    }
}
