package com.g4s.javelin.employee.service.impl;

import com.g4s.javelin.employee.dao.RoleDao;
import com.g4s.javelin.employee.dto.RoleDTO;
import com.g4s.javelin.employee.model.Role;
import com.g4s.javelin.employee.service.RoleService;
import com.g4s.javelin.util.ObjectConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import javax.inject.Inject;

/**
 * Created by sromares on 3/17/16.
 */
public class RoleServiceImpl implements RoleService {

    @Inject
    @Qualifier("roleDao")
    @Lazy
    private RoleDao roleDao;

    @Override
    public RoleDTO create(Role role) {
        return ObjectConverter.convert(roleDao.save(role), RoleDTO.class);
    }

}
