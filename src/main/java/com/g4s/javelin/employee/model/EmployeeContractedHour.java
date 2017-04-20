package com.g4s.javelin.employee.model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by sromares on 3/17/16.
 */
@Entity
public class EmployeeContractedHour {

    @Id
    private Long id;
    @Index
    private Key<Employee> employee;
    @Index
    private Key<ContractHourPeriod> contractHourPeriod;
    private String contractHourThreshold;
    private String contractDays;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Key<ContractHourPeriod> getContractHourPeriod() {
        return contractHourPeriod;
    }

    public void setContractHourPeriod(
            Key<ContractHourPeriod> contractHourPeriod) {
        this.contractHourPeriod = contractHourPeriod;
    }

    public String getContractHourThreshold() {
        return contractHourThreshold;
    }

    public void setContractHourThreshold(String contractHourThreshold) {
        this.contractHourThreshold = contractHourThreshold;
    }

    public String getContractDays() {
        return contractDays;
    }

    public void setContractDays(String contractDays) {
        this.contractDays = contractDays;
    }

    public Key<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Key<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeContractedHour{" +
                "id=" + id +
                ", employee=" + employee +
                ", contractHourPeriod=" + contractHourPeriod +
                ", contractHourThreshold='" + contractHourThreshold + '\'' +
                ", contractDays='" + contractDays + '\'' +
                '}';
    }
}
