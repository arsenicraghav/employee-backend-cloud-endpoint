package com.g4s.javelin.employee.dao.impl;

import com.g4s.javelin.employee.dao.EmployeeDao;
import com.g4s.javelin.employee.model.Employee;

/**
 * Created by sromares on 3/15/16.
 */
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao {

    public EmployeeDaoImpl() {
        super(Employee.class);
    }

}