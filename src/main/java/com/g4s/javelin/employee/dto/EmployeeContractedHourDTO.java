package com.g4s.javelin.employee.dto;

/**
 * Created by sromares on 3/18/16.
 */
public class EmployeeContractedHourDTO {

    private Long id;
    private String contractHourPeriod;
    private String contractHourThreshold;
    private String contractDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractHourPeriod() {
        return contractHourPeriod;
    }

    public void setContractHourPeriod(String contractHourPeriod) {
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
}
