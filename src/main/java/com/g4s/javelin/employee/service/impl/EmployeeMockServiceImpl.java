package com.g4s.javelin.employee.service.impl;

import com.g4s.javelin.employee.dao.EmployeeContractedHourDao;
import com.g4s.javelin.employee.dao.EmployeeDao;
import com.g4s.javelin.employee.dto.EmployeeDTO;
import com.g4s.javelin.employee.dto.EmployeeListDTO;
import com.g4s.javelin.employee.model.Employee;
import com.g4s.javelin.employee.service.EmployeeService;
import com.g4s.javelin.util.MockContractHourGenerator;
import com.g4s.javelin.util.MockEmployeeGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import javax.inject.Inject;

/**
 * Created by sromares on 3/17/16.
 */
public class EmployeeMockServiceImpl implements EmployeeService {

    @Inject
    @Qualifier("employeeDao")
    @Lazy
    private EmployeeDao employeeDao;

    @Inject
    @Qualifier("employeeContractedHourDao")
    @Lazy
    private EmployeeContractedHourDao employeeContractedHourDao;


    @Override
    public EmployeeListDTO list() {
        return null;
    }

    @Override
    public EmployeeDTO get(String id) {
        return null;
    }

    @Override
    public void create() {
        Employee employee = MockEmployeeGenerator.makeFakeEmployee();
        employeeDao.save(employee);
        assignContractHoursToEmployee(employee.getId());
    }

    private void assignContractHoursToEmployee(String employeeId) {
        employeeContractedHourDao.save(MockContractHourGenerator.employeeContractedHour(employeeId));
    }
    public void createDummyEmployee(final int size) {
        for (int ctr = size; ctr >= 0; ctr--) {
            Employee employee = MockEmployeeGenerator.makeFakeEmployee();
            employeeDao.save(employee);
            assignContractHoursToEmployee(employee.getId());
        }
    }

}
