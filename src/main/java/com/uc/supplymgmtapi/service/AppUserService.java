package com.uc.supplymgmtapi.service;

import com.uc.supplymgmtapi.dto.AppUserDTO;
import com.uc.supplymgmtapi.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AppUserService extends GenericService<AppUser>, UserDetailsService {
    List<AppUserDTO> findAllUserByCompanyId(String companyId);

}
