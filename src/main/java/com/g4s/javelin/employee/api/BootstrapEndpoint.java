package com.g4s.javelin.employee.api;

import com.g4s.javelin.employee.exception.EmployeeException;
import com.g4s.javelin.employee.model.ContractHourPeriod;
import com.g4s.javelin.employee.model.JobType;
import com.g4s.javelin.employee.model.OverTimePeriod;
import com.g4s.javelin.employee.model.RegulationOption;
import com.g4s.javelin.employee.model.Role;
import com.g4s.javelin.employee.service.ContractHourPeriodService;
import com.g4s.javelin.employee.service.EmployeeService;
import com.g4s.javelin.employee.service.JobTypeService;
import com.g4s.javelin.employee.service.OverTimePeriodService;
import com.g4s.javelin.employee.service.RegulationOptionService;
import com.g4s.javelin.employee.service.RoleService;
import com.g4s.javelin.employee.service.impl.EmployeeMockServiceImpl;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import javax.inject.Inject;

/**
 * Created by sromares on 3/17/16.
 */
@Api(
        name = "employee",
        version = "v1",
        namespace = @ApiNamespace(ownerName = "G4S Javelin",
                                  ownerDomain = "com.g4s.javelin"),
        description = "API for Employee operational data"
)
public class BootstrapEndpoint {

    @Inject
    @Qualifier("employeeMockService")
    @Lazy
    private EmployeeMockServiceImpl employeeMockService;

    @Inject
    @Qualifier("overTimePeriodService")
    @Lazy
    private OverTimePeriodService overTimePeriodService;

    @Inject
    @Qualifier("jobTypeService")
    @Lazy
    private JobTypeService jobTypeService;

    @Inject
    @Qualifier("regulationOptionService")
    @Lazy
    private RegulationOptionService regulationOptionService;

    @Inject
    @Qualifier("roleService")
    @Lazy
    private RoleService roleService;

    @Inject
    @Qualifier("contractHourPeriodService")
    @Lazy
    private ContractHourPeriodService contractHourThresholdService;


    @ApiMethod(
            name = "debug.bootstrap.create",
            path = "debug/bootstrap/create",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public void batchCreate() throws EmployeeException {
        createOvertimeEnum();
        createJobType();
        createRegulationOption();
        createRole();
        createContractPeriod();
    }

    @ApiMethod(
            name = "debug.employees.create",
            path = "debug/employees/create",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public void create(@Named("size") int size) throws EmployeeException {
        if (size > 1) {
            employeeMockService.createDummyEmployee(size);
        } else {
            employeeMockService.create();
        }

    }

    @ApiMethod(
            name = "debug.overtimePeriod.create",
            path = "debug/overtimePeriod/create",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public void createOvertimeEnum() throws EmployeeException {
        OverTimePeriod overTimePeriod = new OverTimePeriod("WEEKLY", "Weekly");
        overTimePeriodService.create(overTimePeriod);

        overTimePeriod = new OverTimePeriod("FORTNIGHTLY", "Fortnightly");
        overTimePeriodService.create(overTimePeriod);
    }

    @ApiMethod(
            name = "debug.jobType.create",
            path = "debug/jobType/create",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public void createJobType() throws EmployeeException {
        JobType jobType = new JobType("FULL_TIME", "Full Time");
        jobTypeService.create(jobType);

        jobType = new JobType("PART_TIME", "Part Time");
        jobTypeService.create(jobType);

        jobType = new JobType("CASUAL", "Casual");
        jobTypeService.create(jobType);
    }

    @ApiMethod(
            name = "debug.regulationOption.create",
            path = "debug/regulationOption/create",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public void createRegulationOption() throws EmployeeException {
        RegulationOption regulationOption = new RegulationOption("MORE_THAN_AVERAGE", "1");
        regulationOptionService.create(regulationOption);

        regulationOption = new RegulationOption("LESS_THAN_AVERAGE", "2");
        regulationOptionService.create(regulationOption);

        regulationOption = new RegulationOption("AVERAGE", "3");
        regulationOptionService.create(regulationOption);

    }

    @ApiMethod(
            name = "debug.role.create",
            path = "debug/role/create",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public void createRole() throws EmployeeException {
        String[] roleArr = {"AIR Airport Security Officer", "Site Supervisor", "Mobile Security Officer", "Patrols Officer"};
        for (int i = 0; i < roleArr.length; i++) {
            Role role = new Role("role" + i, roleArr[i]);
            roleService.create(role);
        }
    }

    @ApiMethod(
            name = "debug.contractPeriod.create",
            path = "debug/contractPeriod/create",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public void createContractPeriod() throws EmployeeException {
        ContractHourPeriod contractHourPeriod = new ContractHourPeriod("WEEKLY", "Weekly");
        contractHourThresholdService.create(contractHourPeriod);

        contractHourPeriod = new ContractHourPeriod("DAILY", "Daily");
        contractHourThresholdService.create(contractHourPeriod);

        contractHourPeriod = new ContractHourPeriod("MONTHLY", "Monthly");
        contractHourThresholdService.create(contractHourPeriod);

        contractHourPeriod = new ContractHourPeriod("YEARLY", "Yearly");
        contractHourThresholdService.create(contractHourPeriod);
    }
}
