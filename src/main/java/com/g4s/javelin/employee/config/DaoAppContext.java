package com.g4s.javelin.employee.config;

import com.g4s.javelin.employee.dao.*;
import com.g4s.javelin.employee.dao.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class DaoAppContext {

    @Bean(name = "employeeDao")
    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoImpl();
    }

    @Bean(name = "overTimePeriodDao")
    public OverTimePeriodDao getOverTimePeriodDao() {
        return new OverTimePeriodDaoImpl();
    }

    @Bean(name = "jobTypeDao")
    public JobTypeDao getJobTypeDao() {
        return new JobTypeDaoImpl();
    }

    @Bean(name = "regulationOptionDao")
    public RegulationOptionDao getRegulationOptionDao() {
        return new RegulationOptionImpl();
    }

    @Bean(name = "roleDao")
    public RoleDao getRoleDao() {
        return new RoleDaoImpl();
    }

    @Bean(name = "contractHourPeriodDao")
    public ContractHourPeriodDao getContractHourPeriodDaoDao() {
        return new ContractHourPeriodDaoImpl();
    }

    @Bean(name = "employeeContractedHourDao")
    public EmployeeContractedHourDao getEmployeeContractedHourDao() {
        return new EmployeeContractedHourDaoImpl();
    }


}
