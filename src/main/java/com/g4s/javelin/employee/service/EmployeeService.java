package com.g4s.javelin.employee.service;

import com.g4s.javelin.employee.dto.EmployeeDTO;
import com.g4s.javelin.employee.dto.EmployeeListDTO;
import com.g4s.javelin.employee.exception.EmployeeNotFoundException;

/**
 * Created by sromares on 3/15/16.
 */
public interface EmployeeService {

    EmployeeListDTO list();

    EmployeeDTO get(String id) throws EmployeeNotFoundException;

    void create();


}