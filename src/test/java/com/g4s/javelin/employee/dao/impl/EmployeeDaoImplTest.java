package com.g4s.javelin.employee.dao.impl;

import com.g4s.javelin.employee.dao.EmployeeDao;
import com.g4s.javelin.employee.model.Employee;
import com.g4s.javelin.util.MockEmployeeGenerator;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class EmployeeDaoImplTest {

    private final LocalServiceTestHelper HELPER = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
    private EmployeeDao employeeDao;

    @Before
    public void setUp() {
        HELPER.setUp();
        employeeDao = new EmployeeDaoImpl();
    }

    @After
    public void tearDown() {
        HELPER.tearDown();
    }

    @Test
    public void findAllTest_noData() {
        final Iterable<Employee> employeeList = employeeDao.findAll();

        Assert.assertEquals(0, ((Collection<?>) employeeList).size());
    }

    @Test
    public void findAllTest_withData() {
        final Employee employee = MockEmployeeGenerator.makeFakeEmployee();
        employeeDao.save(employee);

        final Iterable<Employee> employeeList = employeeDao.findAll();

        Assert.assertEquals(1, ((Collection<?>) employeeList).size());
    }

    @Test
    public void findOneTest_notExisting() {
        final Employee employee = MockEmployeeGenerator.makeFakeEmployee();
        final Employee retrievedEmployee = employeeDao.findOne(employee.getId());

        Assert.assertNull(retrievedEmployee);
    }

    @Test
    public void findOneTest_existing() {
        final Employee employee = MockEmployeeGenerator.makeFakeEmployee();
        final Employee savedEmployee = employeeDao.save(employee);

        Employee retrievedList = employeeDao.findOne(savedEmployee.getId());

        Assert.assertEquals(savedEmployee, retrievedList);
    }
}
