package com.g4s.javelin.employee.service.impl;

import com.g4s.javelin.employee.dao.OverTimePeriodDao;
import com.g4s.javelin.employee.model.OverTimePeriod;
import com.g4s.javelin.employee.service.OverTimePeriodService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import javax.inject.Inject;

/**
 * Created by sromares on 3/16/16.
 */
public class OverTimePeriodServiceImpl implements OverTimePeriodService {

    @Inject
    @Qualifier("overTimePeriodDao")
    @Lazy
    private OverTimePeriodDao overTimePeriodDao;

    @Override
    public void create(OverTimePeriod overTimePeriod) {
        overTimePeriodDao.save(overTimePeriod);
    }


}
