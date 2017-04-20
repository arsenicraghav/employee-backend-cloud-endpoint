package com.g4s.javelin.employee.service;

import com.g4s.javelin.employee.dto.JobTypeDTO;
import com.g4s.javelin.employee.model.JobType;

/**
 * Created by sromares on 3/17/16.
 */
public interface JobTypeService {

    JobTypeDTO create(JobType jobType);
}
