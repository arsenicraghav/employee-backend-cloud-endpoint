package com.g4s.javelin.employee.config;

import com.g4s.javelin.employee.service.ContractHourPeriodService;
import com.g4s.javelin.employee.service.EmployeeContractedHourService;
import com.g4s.javelin.employee.service.EmployeeService;
import com.g4s.javelin.employee.service.JobTypeService;
import com.g4s.javelin.employee.service.OverTimePeriodService;
import com.g4s.javelin.employee.service.RegulationOptionService;
import com.g4s.javelin.employee.service.RoleService;
import com.g4s.javelin.employee.service.impl.ContractHourPeriodServiceImpl;
import com.g4s.javelin.employee.service.impl.EmployeeContractedHourServiceImpl;
import com.g4s.javelin.employee.service.impl.EmployeeMockServiceImpl;
import com.g4s.javelin.employee.service.impl.EmployeeServiceImpl;
import com.g4s.javelin.employee.service.impl.JobTypeServiceImpl;
import com.g4s.javelin.employee.service.impl.OverTimePeriodServiceImpl;
import com.g4s.javelin.employee.service.impl.RegulationOptionServiceImpl;
import com.g4s.javelin.employee.service.impl.RoleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class ServiceAppContext {

    @Bean(name = "employeeService")
    public EmployeeService getEmployeeService() {
        return new EmployeeServiceImpl();
    }

    @Bean(name = "employeeMockService")
    public EmployeeMockServiceImpl getEmployeeMockService() {
        return new EmployeeMockServiceImpl();
    }

    @Bean(name = "overTimePeriodService")
    public OverTimePeriodService getOverTimePeriodService() {
        return new OverTimePeriodServiceImpl();
    }

    @Bean(name = "jobTypeService")
    public JobTypeService getJobTypeService() {
        return new JobTypeServiceImpl();
    }

    @Bean(name = "regulationOptionService")
    public RegulationOptionService getRegulationOptionService() {
        return new RegulationOptionServiceImpl();
    }

    @Bean(name = "roleService")
    public RoleService getRoleService() {
        return new RoleServiceImpl();
    }

    @Bean(name = "contractHourPeriodService")
    public ContractHourPeriodService getcontractHourPeriodService() {
        return new ContractHourPeriodServiceImpl();
    }

    @Bean(name = "employeeContractedHourService")
    public EmployeeContractedHourService getEmployeeContractedHourService() {
        return new EmployeeContractedHourServiceImpl();
    }

}
