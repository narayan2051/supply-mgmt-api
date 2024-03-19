package com.uc.supplymgmtapi.service;

import com.uc.supplymgmtapi.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends GenericService<AppUser>, UserDetailsService {
}
