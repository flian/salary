package com.nagarro.salary;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Foy Lian
 * Date: 11/2/2021
 * Time: 2:30 PM
 */
public interface SalaryCalculator {
    public  boolean support(Integer month,EmployeeItem item);
    public void calculate(Integer month,EmployeeItem item);
}
