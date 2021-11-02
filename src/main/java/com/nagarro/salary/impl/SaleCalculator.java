package com.nagarro.salary.impl;

import com.nagarro.salary.EmployeeItem;
import com.nagarro.salary.SalaryCalculator;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Foy Lian
 * Date: 11/2/2021
 * Time: 3:06 PM
 */
public class SaleCalculator implements SalaryCalculator {
    @Override
    public boolean support(Integer month, EmployeeItem item) {
        return "sale".equals(item.getType());
    }

    @Override
    public void calculate(Integer month, EmployeeItem item) {
        BigDecimal baseSaleAmt = BigDecimal.valueOf(20000);
        BigDecimal fiveSaleAmt = BigDecimal.valueOf(30000);
        BigDecimal baseSalary = BigDecimal.valueOf(3000);
        if (item.getAmount().compareTo(fiveSaleAmt) < 1) {
            BigDecimal saleAmt = item.getAmount().subtract(baseSaleAmt).multiply(BigDecimal.valueOf(0.05));
            item.setSalary(baseSalary.add(saleAmt));
        }else{
            BigDecimal saleAmt = item.getAmount().subtract(baseSaleAmt).multiply(BigDecimal.valueOf(0.08));
            item.setSalary(baseSalary.add(saleAmt));
        }
    }
}
