package com.g4s.javelin.employee.dao.impl;

import com.g4s.javelin.employee.dao.DaoManager;
import com.g4s.javelin.employee.dao.EmployeeContractedHourDao;
import com.g4s.javelin.employee.model.Employee;
import com.g4s.javelin.employee.model.EmployeeContractedHour;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;

import java.util.List;

/**
 * Created by sromares on 3/17/16.
 */
public class EmployeeContractedHourDaoImpl extends BaseDaoImpl<EmployeeContractedHour> implements EmployeeContractedHourDao {

    private final DaoManager DAO_MANAGER = DaoManager.getInstance();

    public EmployeeContractedHourDaoImpl() {
        super(EmployeeContractedHour.class);
    }

    @Override
    public List<EmployeeContractedHour> findByEmployeeKey(Key<Employee> employeeKey) {

        final Objectify ofy = DAO_MANAGER.getObjectify();
        return ofy.load()
                  .type(EmployeeContractedHour.class)
                  .filter("employee", employeeKey)
                  .list();
    }
}