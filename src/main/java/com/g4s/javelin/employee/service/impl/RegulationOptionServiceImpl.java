package com.g4s.javelin.employee.service.impl;

import com.g4s.javelin.employee.dao.RegulationOptionDao;
import com.g4s.javelin.employee.dto.RegulationOptionDTO;
import com.g4s.javelin.employee.model.RegulationOption;
import com.g4s.javelin.employee.service.RegulationOptionService;
import com.g4s.javelin.util.ObjectConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import javax.inject.Inject;

/**
 * Created by sromares on 3/17/16.
 */
public class RegulationOptionServiceImpl implements RegulationOptionService {


    @Inject
    @Qualifier("regulationOptionDao")
    @Lazy
    private RegulationOptionDao regulationOptionDao;


    @Override
    public RegulationOptionDTO create(RegulationOption regulationOption) {
        return ObjectConverter.convert(regulationOptionDao.save(regulationOption), RegulationOptionDTO.class);
    }
}
