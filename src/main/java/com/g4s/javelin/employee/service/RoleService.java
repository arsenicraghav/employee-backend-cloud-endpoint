package com.g4s.javelin.employee.service;

import com.g4s.javelin.employee.dto.RoleDTO;
import com.g4s.javelin.employee.model.Role;

/**
 * Created by sromares on 3/17/16.
 */
public interface RoleService {

    RoleDTO create(Role role);
}
