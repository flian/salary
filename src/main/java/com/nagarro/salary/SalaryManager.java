package com.nagarro.salary;

import com.nagarro.salary.impl.BirthdayCacluator;
import com.nagarro.salary.impl.FixSalaryCalculator;
import com.nagarro.salary.impl.HourCalculator;
import com.nagarro.salary.impl.SaleCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Foy Lian
 * Date: 11/2/2021
 * Time: 2:33 PM
 */
public class SalaryManager {
    private List<SalaryCalculator> calculators= new ArrayList<>();

    public SalaryManager() {
        calculators.add(new BirthdayCacluator());
        calculators.add(new FixSalaryCalculator());
        calculators.add(new HourCalculator());
        calculators.add(new SaleCalculator());
    }

    public BigDecimal calculate(Integer month, List<EmployeeItem> employees) {
        for (EmployeeItem employee : employees) {
            for (SalaryCalculator sc : calculators) {
                if (sc.support(month, employee)) {
                    sc.calculate(month, employee);
                }
            }
        }
        BigDecimal total = BigDecimal.ZERO;
        for (EmployeeItem employee : employees) {
            total = total.add(employee.getSalary());
        }
        return total;
    }

}
