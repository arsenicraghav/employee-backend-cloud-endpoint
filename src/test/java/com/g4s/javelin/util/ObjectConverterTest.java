package com.g4s.javelin.util;

import com.g4s.javelin.employee.dto.EmployeeDTO;
import com.g4s.javelin.employee.model.Employee;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ObjectConverterTest {

    @Test
    public void convertTest_withMatchingFields() {
        final Employee employee = new Employee();
        employee.setFirstname("Test FirstName");
        employee.setSurname("Test Surname");

        final EmployeeDTO result = ObjectConverter.convert(employee, EmployeeDTO.class);

        Assert.assertEquals(employee.getFirstname(), result.getFirstname());
        Assert.assertEquals(employee.getSurname(), result.getSurname());
    }

    @Test
    public void convertTest_noMatchingFields() {
        final Map<String, String> testFields = new HashMap<>();
        testFields.put("mockField1", "mockValue1");
        testFields.put("mockField2", "mockValue2");

        final EmployeeDTO result = ObjectConverter.convert(testFields, EmployeeDTO.class);

        Assert.assertNull(result.getFirstname());
        Assert.assertNull(result.getSurname());
    }

    @Test
    public void convertTest_withMatchingMapFields() {
        final String firstName = "firstname";
        final String surname = "surname";

        final Map<String, String> testFields = new HashMap<>();
        testFields.put(firstName, firstName);
        testFields.put(surname, surname);

        final EmployeeDTO result = ObjectConverter.convert(testFields, EmployeeDTO.class);

        Assert.assertEquals(firstName, result.getFirstname());
        Assert.assertEquals(surname, result.getSurname());
    }

}
