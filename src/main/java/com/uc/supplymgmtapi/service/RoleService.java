package com.uc.supplymgmtapi.service;

import com.uc.supplymgmtapi.entity.Role;

public interface RoleService extends GenericService<Role> {
    Role findByRoleName(String roleName);
}
