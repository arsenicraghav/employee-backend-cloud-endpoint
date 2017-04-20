package com.g4s.javelin.employee.dao.impl;

import com.g4s.javelin.employee.dao.JobTypeDao;
import com.g4s.javelin.employee.model.JobType;

/**
 * Created by sromares on 3/17/16.
 */
public class JobTypeDaoImpl extends BaseDaoImpl<JobType> implements JobTypeDao {

    public JobTypeDaoImpl() {
        super(JobType.class);
    }


}
