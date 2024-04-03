package com.uc.supplymgmtapi.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Setter
@Getter
public class AuthenticatedUser extends User {
    private Long companyId;
    private String firstName;
    private String lastName;

    public AuthenticatedUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long companyId, String firstName, String lastName) {
        super(username, password, authorities);
        this.companyId = companyId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
