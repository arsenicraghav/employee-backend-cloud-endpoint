package com.g4s.javelin.employee.dao;

import com.g4s.javelin.employee.model.*;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public final class DaoManager {

    private static DaoManager self;

    static {
        registerEntities();
    }

    private DaoManager() { }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static DaoManager getInstance() {
        if (self == null) {
            self = new DaoManager();
        }

        return self;
    }

    private static void registerEntities() {
        ObjectifyService.begin();
        ObjectifyService.factory().register(Employee.class);
        ObjectifyService.factory().register(OverTimePeriod.class);
        ObjectifyService.factory().register(JobType.class);
        ObjectifyService.factory().register(RegulationOption.class);
        ObjectifyService.factory().register(Role.class);
        ObjectifyService.factory().register(ContractHourPeriod.class);
        ObjectifyService.factory().register(EmployeeContractedHour.class);
    }

    /**
     * Gets objectify.
     *
     * @return the objectify
     */
    public Objectify getObjectify() {
        return ObjectifyService.ofy();
    }
}
