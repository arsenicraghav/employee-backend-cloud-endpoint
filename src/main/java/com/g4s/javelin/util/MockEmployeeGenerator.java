package com.g4s.javelin.util;

import com.g4s.javelin.employee.model.Employee;
import com.g4s.javelin.employee.model.JobType;
import com.g4s.javelin.employee.model.OverTimePeriod;
import com.g4s.javelin.employee.model.RegulationOption;
import com.g4s.javelin.employee.model.Role;
import com.github.javafaker.Address;
import com.google.appengine.api.datastore.GeoPt;
import com.googlecode.objectify.Key;

import java.util.ArrayList;
import java.util.List;

public final class MockEmployeeGenerator {

    public static Employee makeFakeEmployee() {
        EmployeeFieldFaker faker = new EmployeeFieldFaker();
        Employee employee = new Employee();

        employee.setId(faker.id());
        employee.setTitle(faker.title());
        employee.setFirstname(faker.name().firstName());
        employee.setMiddlename(faker.name().lastName());
        employee.setSurname(faker.name().lastName());
        employee.setInitials(employee.getFirstname().substring(0, 1) + employee.getSurname().substring(0, 1));
        employee.setDateOfBirth(faker.dateOfBirth());
        employee.setMobileNumber(faker.phoneNumber().phoneNumber());
        employee.setLandlineNumber(faker.phoneNumber().phoneNumber());
        employee.setEmergencyContactNumber(faker.phoneNumber().phoneNumber());
        employee.setEmailAddress(employee.getFirstname() + "." + employee.getSurname() + "@g4s.com");

        Address primaryAddress = faker.address();
        employee.setAddressLine1(primaryAddress.streetAddress(true));
        employee.setAddressLine2(faker.address().streetAddress(false));
        employee.setAddressLine3(faker.address().streetAddress(true));
        employee.setCity(primaryAddress.city());
        employee.setState(primaryAddress.state());
        employee.setCountry(primaryAddress.country());
        employee.setPostCode(primaryAddress.zipCode());
        employee.setGeoLocation(new GeoPt(Float.parseFloat(primaryAddress.latitude()),
                Float.parseFloat(primaryAddress.longitude())));
        employee.setPayIndicator("Contract rate");
        employee.setPayGroup(faker.payGroup());
        employee.setBasicHours(faker.basicHours());
        employee.setOvertimeThreshold(faker.basicHours());
        employee.setRank(faker.rank());

        employee.setOverTimePeriod(ObjectifyUtils.createKey(OverTimePeriod.class, faker.overtimePeriod().getId()));
        employee.setJobType(ObjectifyUtils.createKey(JobType.class, faker.jobType().getId()));
        employee.setRegulationOption(ObjectifyUtils.createKey(RegulationOption.class, faker.regulationOption()));

        List<String> roles = faker.roles();
        employee.setRoles(createRoleKeys(roles));

        return employee;
    }

    private static List<Key<Role>> createRoleKeys(List<String> roles) {

        List<Key<Role>> roleKeys = new ArrayList<>();
        for (String role : roles) {
            Key<Role> roleKey = ObjectifyUtils.createKey(Role.class, role);
            roleKeys.add(roleKey);
        }
        return roleKeys;
    }
}
