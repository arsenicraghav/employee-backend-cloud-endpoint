package com.g4s.javelin.employee.service;

import com.g4s.javelin.employee.dto.EmployeeContractedHourListDTO;
import com.g4s.javelin.employee.exception.EmployeeNotFoundException;

/**
 * Created by sromares on 3/18/16.
 */
public interface EmployeeContractedHourService {

    EmployeeContractedHourListDTO findByEmployeeId(String employeeId) throws EmployeeNotFoundException;
}
