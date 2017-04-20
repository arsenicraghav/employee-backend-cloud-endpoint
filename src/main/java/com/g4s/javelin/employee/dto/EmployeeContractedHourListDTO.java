package com.g4s.javelin.employee.dto;

import java.util.List;

/**
 * Created by sromares on 3/18/16.
 */
public class EmployeeContractedHourListDTO {

    private List<EmployeeContractedHourDTO> employeeContractedHours;

    public EmployeeContractedHourListDTO(List<EmployeeContractedHourDTO> employeeContractedHours) {
        this.employeeContractedHours = employeeContractedHours;
    }

    public List<EmployeeContractedHourDTO> getEmployeeContractedHours() {
        return employeeContractedHours;
    }

    public void setEmployeeContractedHours(
            List<EmployeeContractedHourDTO> employeeContractedHours) {
        this.employeeContractedHours = employeeContractedHours;
    }
}
