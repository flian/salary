package com.nagarro.salary;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: Foy Lian
 * Date: 11/2/2021
 * Time: 3:20 PM
 */
public class Main {
    public static void main(String[] args) throws DocumentException {
        SalaryManager salaryManager = new SalaryManager();
        Map<Integer, List<EmployeeItem>> xmlResult = new HashMap<>();
        File inputFile = new File(Main.class.getClassLoader().getResource("salary.xml").getFile());
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputFile);
        Element rootElement = document.getRootElement();
        List months = rootElement.elements("month");
        for (int i = 0; i < months.size(); i++) {
            Element e = (Element) months.get(i);
            Integer month = Integer.parseInt(e.attributeValue("value"));
            List<EmployeeItem> employees = new ArrayList<>();
            xmlResult.put(month, employees);
            List es = e.elements("employee");
            for (int j = 0; j < es.size(); j++) {
                EmployeeItem ei = new EmployeeItem();
                employees.add(ei);
                Element employee = (Element) es.get(j);
                ei.setName(employee.attributeValue("name"));
                ei.setType(employee.attributeValue("type"));
                ei.setBirthday(employee.attributeValue("birthday"));
                String wh = employee.attributeValue("workingHours");
                if (wh != null) {
                    ei.setWorkingHours(new BigDecimal(wh));
                }
                String amt = employee.attributeValue("amount");
                if (amt != null) {
                    ei.setAmount(new BigDecimal(amt));
                }

            }
        }
        for (Integer month : xmlResult.keySet()) {
            BigDecimal total = salaryManager.calculate(month, xmlResult.get(month));
            System.out.println("month: " + month + " total:" + total.setScale(2,BigDecimal.ROUND_HALF_UP));
        }
    }

}
