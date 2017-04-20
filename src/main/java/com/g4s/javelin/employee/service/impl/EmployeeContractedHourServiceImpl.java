package com.g4s.javelin.employee.service.impl;

import com.g4s.javelin.employee.dao.ContractHourPeriodDao;
import com.g4s.javelin.employee.dao.EmployeeContractedHourDao;
import com.g4s.javelin.employee.dto.EmployeeContractedHourDTO;
import com.g4s.javelin.employee.dto.EmployeeContractedHourListDTO;
import com.g4s.javelin.employee.exception.EmployeeNotFoundException;
import com.g4s.javelin.employee.model.ContractHourPeriod;
import com.g4s.javelin.employee.model.Employee;
import com.g4s.javelin.employee.model.EmployeeContractedHour;
import com.g4s.javelin.employee.service.EmployeeContractedHourService;
import com.g4s.javelin.util.ObjectConverter;
import com.g4s.javelin.util.ObjectifyUtils;
import com.googlecode.objectify.Key;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sromares on 3/18/16.
 */
public class EmployeeContractedHourServiceImpl implements EmployeeContractedHourService {

    @Inject
    @Qualifier("employeeContractedHourDao")
    @Lazy
    private EmployeeContractedHourDao employeeContractedHourDao;

    @Inject
    @Qualifier("contractHourPeriodDao")
    @Lazy
    private ContractHourPeriodDao contractHourPeriodDao;


    @Override
    public EmployeeContractedHourListDTO findByEmployeeId(String employeeId) throws EmployeeNotFoundException {
        List<EmployeeContractedHourDTO> employeeContractedHourDTOs = new ArrayList<>();

        Key<Employee> employeeKey = ObjectifyUtils.createKey(Employee.class, employeeId);
        List<EmployeeContractedHour> employeeContractedHourList = employeeContractedHourDao.findByEmployeeKey(
                employeeKey);

        for (EmployeeContractedHour employeeContractedHour : employeeContractedHourList) {
            EmployeeContractedHourDTO employeeContractedHourDTO = ObjectConverter.convert(employeeContractedHour,
                                                                                          EmployeeContractedHourDTO.class);
            employeeContractedHourDTO.setContractHourPeriod(
                    findContractHourByKey(employeeContractedHour.getContractHourPeriod()));
            employeeContractedHourDTOs.add(employeeContractedHourDTO);
        }
        return new EmployeeContractedHourListDTO(employeeContractedHourDTOs);
    }

    private String findContractHourByKey(Key<ContractHourPeriod> key) {
        return contractHourPeriodDao.findByKey(key)
                                    .getType();
    }
}
