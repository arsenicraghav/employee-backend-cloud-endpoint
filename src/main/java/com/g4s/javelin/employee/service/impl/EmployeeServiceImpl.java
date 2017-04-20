package com.g4s.javelin.employee.service.impl;

import com.g4s.javelin.employee.dao.*;
import com.g4s.javelin.employee.dto.EmployeeDTO;
import com.g4s.javelin.employee.dto.EmployeeListDTO;
import com.g4s.javelin.employee.exception.EmployeeNotFoundException;
import com.g4s.javelin.employee.model.*;
import com.g4s.javelin.employee.service.EmployeeService;
import com.g4s.javelin.util.ObjectConverter;
import com.googlecode.objectify.Key;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sromares on 3/16/16.
 */
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    @Qualifier("employeeDao")
    @Lazy
    private EmployeeDao employeeDao;

    @Inject
    @Qualifier("overTimePeriodDao")
    @Lazy
    private OverTimePeriodDao overTimePeriodDao;

    @Inject
    @Qualifier("jobTypeDao")
    @Lazy
    private JobTypeDao jobTypeDao;

    @Inject
    @Qualifier("regulationOptionDao")
    @Lazy
    private RegulationOptionDao regulationOptionDao;


    @Inject
    @Qualifier("roleDao")
    @Lazy
    private RoleDao roleDao;


    @Override
    public EmployeeListDTO list() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        Iterable<com.g4s.javelin.employee.model.Employee> employeeIterable = employeeDao.findAll();
        if (employeeIterable != null) {
            for (com.g4s.javelin.employee.model.Employee employee : employeeIterable) {
                EmployeeDTO employeeDTO = ObjectConverter.convert(employee, EmployeeDTO.class);

                employeeDTO.setOverTimePeriod(findOvertimePeriodByKey(employee.getOverTimePeriod()));
                employeeDTO.setJobType(findJobTypeByKey(employee.getJobType()));
                employeeDTO.setRegulationOption(findRegulationOptionByKey(employee.getRegulationOption()));
                employeeDTO.setRoles(findRoleByKey(employee.getRoles()));
                employeeDTOList.add(employeeDTO);
            }
        }
        return new EmployeeListDTO(employeeDTOList);
    }


    @Override
    public EmployeeDTO get(String id) throws EmployeeNotFoundException {
        Employee employee = employeeDao.findOne(id);
        if (employee == null) {
            throw new EmployeeNotFoundException(HttpStatus.NOT_FOUND.value(), "Employee not found : " + id);
        }
        EmployeeDTO employeeDTO = ObjectConverter.convert(employee, EmployeeDTO.class);
        employeeDTO.setOverTimePeriod(findOvertimePeriodByKey(employee.getOverTimePeriod()));
        employeeDTO.setJobType(findJobTypeByKey(employee.getJobType()));
        employeeDTO.setRegulationOption(findRegulationOptionByKey(employee.getRegulationOption()));
        employeeDTO.setRoles(findRoleByKey(employee.getRoles()));
        return employeeDTO;
    }

    @Override
    public void create() {

    }


    private String findOvertimePeriodByKey(Key<OverTimePeriod> key) {
        return overTimePeriodDao.findByKey(key)
                                .getType();
    }


    private String findJobTypeByKey(Key<JobType> key) {
        return jobTypeDao.findByKey(key)
                         .getType();
    }

    private String findRegulationOptionByKey(Key<RegulationOption> key) {
        return regulationOptionDao.findByKey(key)
                                  .getType();
    }

    private List<String> findRoleByKey(List<Key<Role>> keys) {
        List<String> roles = new ArrayList<>();
        for (Key<Role> roleKey : keys) {
            roles.add(roleDao.findByKey(roleKey)
                             .getType());
        }
        return roles;
    }


}
