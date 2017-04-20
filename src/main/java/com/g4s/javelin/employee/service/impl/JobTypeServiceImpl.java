package com.g4s.javelin.employee.service.impl;

import com.g4s.javelin.employee.dao.JobTypeDao;
import com.g4s.javelin.employee.dto.JobTypeDTO;
import com.g4s.javelin.employee.model.JobType;
import com.g4s.javelin.employee.service.JobTypeService;
import com.g4s.javelin.util.ObjectConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import javax.inject.Inject;

/**
 * Created by sromares on 3/17/16.
 */
public class JobTypeServiceImpl implements JobTypeService {

    @Inject
    @Qualifier("jobTypeDao")
    @Lazy
    private JobTypeDao jobTypeDao;

    @Override
    public JobTypeDTO create(JobType jobType) {
        return ObjectConverter.convert(jobTypeDao.save(jobType), JobTypeDTO.class);
    }
}
