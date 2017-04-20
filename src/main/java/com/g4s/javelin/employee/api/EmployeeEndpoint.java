package com.g4s.javelin.employee.api;

import com.g4s.javelin.employee.dto.EmployeeContractedHourListDTO;
import com.g4s.javelin.employee.dto.EmployeeDTO;
import com.g4s.javelin.employee.dto.EmployeeListDTO;
import com.g4s.javelin.employee.exception.EmployeeException;
import com.g4s.javelin.employee.exception.EmployeeNotFoundException;
import com.g4s.javelin.employee.service.EmployeeContractedHourService;
import com.g4s.javelin.employee.service.EmployeeService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import javax.inject.Inject;

/**
 * Created by sromares on 3/15/16.
 */
@Api(
        name = "employee",
        version = "v1",
        namespace = @ApiNamespace(ownerName = "G4S Javelin",
                                  ownerDomain = "com.g4s.javelin"),
        description = "API for Employee operational data"
)
public class EmployeeEndpoint {

    @Inject
    @Qualifier("employeeService")
    @Lazy
    private EmployeeService employeeService;

    @Inject
    @Qualifier("employeeContractedHourService")
    @Lazy
    private EmployeeContractedHourService employeeContractedHourService;


    @ApiMethod(
            name = "employees.list",
            path = "employees/list",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public EmployeeListDTO list() throws EmployeeException {
        return employeeService.list();
    }

    @ApiMethod(
            name = "employees.get",
            path = "employees/get",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public EmployeeDTO get(@Named("id") String id) throws EmployeeNotFoundException {
        return employeeService.get(id);
    }

    @ApiMethod(
            name = "contractedHour.get",
            path = "contractedHour/get",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public EmployeeContractedHourListDTO getContractedHour(
            @Named("id") String employeeId) throws EmployeeNotFoundException {
        return employeeContractedHourService.findByEmployeeId(employeeId);
    }


}
