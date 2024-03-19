package com.uc.supplymgmtapi.service.impl;

import com.uc.supplymgmtapi.entity.Role;
import com.uc.supplymgmtapi.repository.RoleRepository;
import com.uc.supplymgmtapi.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findById(String id) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
