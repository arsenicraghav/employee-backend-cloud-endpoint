package com.g4s.javelin.employee.dao;

import com.g4s.javelin.employee.model.Employee;
import com.g4s.javelin.employee.model.EmployeeContractedHour;
import com.googlecode.objectify.Key;

import java.util.List;

/**
 * Created by sromares on 3/17/16.
 */
public interface EmployeeContractedHourDao extends BaseDao<EmployeeContractedHour, String> {

    List<EmployeeContractedHour> findByEmployeeKey(Key<Employee> employeeKey);
}
