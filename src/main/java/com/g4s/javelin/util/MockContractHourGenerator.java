package com.g4s.javelin.util;

import com.g4s.javelin.employee.model.ContractHourPeriod;
import com.g4s.javelin.employee.model.Employee;
import com.g4s.javelin.employee.model.EmployeeContractedHour;

/**
 * Created by sromares on 3/18/16.
 */
public class MockContractHourGenerator {

    public static EmployeeContractedHour employeeContractedHour(String employeeId){
        EmployeeContractedHour employeeContractedHour = new EmployeeContractedHour();
        employeeContractedHour.setEmployee(ObjectifyUtils.createKey(Employee.class, employeeId));
        employeeContractedHour.setContractHourPeriod(ObjectifyUtils.createKey(ContractHourPeriod.class, "WEEKLY"));
        employeeContractedHour.setContractHourThreshold("40");
        employeeContractedHour.setContractDays("5");
        return employeeContractedHour;
    }
}
