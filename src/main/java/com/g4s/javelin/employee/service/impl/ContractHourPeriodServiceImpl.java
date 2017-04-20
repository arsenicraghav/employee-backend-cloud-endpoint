package com.g4s.javelin.employee.service.impl;

import com.g4s.javelin.employee.dao.ContractHourPeriodDao;
import com.g4s.javelin.employee.dto.ContractHourPeriodDTO;
import com.g4s.javelin.employee.model.ContractHourPeriod;
import com.g4s.javelin.employee.service.ContractHourPeriodService;
import com.g4s.javelin.util.ObjectConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import javax.inject.Inject;

/**
 * Created by sromares on 3/17/16.
 */
public class ContractHourPeriodServiceImpl implements ContractHourPeriodService {


    @Inject
    @Qualifier("contractHourPeriodDao")
    @Lazy
    private ContractHourPeriodDao contractHourPeriodDao;

    @Override
    public ContractHourPeriodDTO create(ContractHourPeriod contractHourThreshold) {
        return ObjectConverter.convert(contractHourPeriodDao.save(contractHourThreshold),
                                       ContractHourPeriodDTO.class);
    }
}
