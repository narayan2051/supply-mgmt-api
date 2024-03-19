package com.uc.supplymgmtapi.service.impl;

import com.uc.supplymgmtapi.entity.AppUser;
import com.uc.supplymgmtapi.entity.Role;
import com.uc.supplymgmtapi.repository.AppUserRepository;
import com.uc.supplymgmtapi.service.AppUserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl( AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser findById(String id) {
        return null;
    }

    @Override
    public List<AppUser> findAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> userDetail = appUserRepository.findByEmail(email);
        if (userDetail.isPresent()) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            userDetail.get().getRoles().forEach(role -> {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
            });
            return new User(userDetail.get().getEmail(), userDetail.get().getPassword(), grantedAuthorities);
        }
        // Converting userDetail to UserDetails

        throw new UsernameNotFoundException(email);
    }

}
