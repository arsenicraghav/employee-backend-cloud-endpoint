package com.g4s.javelin.employee.dto;

import java.util.List;

/**
 * Created by sromares on 3/15/16.
 */
public class EmployeeListDTO {

    private List<EmployeeDTO> employees;

    public EmployeeListDTO(List<EmployeeDTO> employeeDTOList) {
        this.employees = employeeDTOList;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
