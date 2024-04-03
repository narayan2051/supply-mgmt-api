package com.uc.supplymgmtapi.service.impl;

import com.uc.supplymgmtapi.dto.AppUserDTO;
import com.uc.supplymgmtapi.entity.AppUser;

import com.uc.supplymgmtapi.entity.AuthenticatedUser;
import com.uc.supplymgmtapi.repository.AppUserRepository;
import com.uc.supplymgmtapi.service.AppUserService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AppUserServiceImpl implements AppUserService {

    AppUserRepository appUserRepository;


    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser findById(Long id) {
        return null;
    }

    @Override
    public List<AppUser> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> userDetail = appUserRepository.findByEmail(email.toLowerCase());
        if (userDetail.isPresent()) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            userDetail.get().getRoles().forEach(role -> {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
            });
            return new AuthenticatedUser(userDetail.get().getEmail(), userDetail.get().getPassword(), grantedAuthorities,
                    userDetail.get().getCompany() != null ? userDetail.get().getCompany().getId() : null, userDetail.get().getFirstName(), userDetail.get().getLastName());
        }
        // Converting userDetail to UserDetails

        throw new UsernameNotFoundException(email);
    }

    @Override
    public List<AppUserDTO> findAllUserByCompanyId(String companyId) {

        List<AppUserDTO> userList = new ArrayList<>();
        appUserRepository.findAllByCompanyId(companyId).forEach(item -> {
            userList.add(AppUserDTO.builder().firstName(item.getFirstName())
                    .lastName(item.getLastName()).phone(item.getPhone()).email(item.getEmail()).companyId(item.getCompany().getId()).build());
        });

        return userList;
    }
}
