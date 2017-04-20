package com.g4s.javelin.employee.dao.impl;

import com.g4s.javelin.employee.dao.RoleDao;
import com.g4s.javelin.employee.model.Role;

/**
 * Created by sromares on 3/17/16.
 */
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

    public RoleDaoImpl() {
        super(Role.class);
    }


}

