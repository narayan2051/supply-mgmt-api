package com.uc.supplymgmtapi.controller;

import com.uc.supplymgmtapi.dto.Login;
import com.uc.supplymgmtapi.dto.TokenDTO;
import com.uc.supplymgmtapi.entity.AppUser;
import com.uc.supplymgmtapi.entity.Role;
import com.uc.supplymgmtapi.security.JwtService;
import com.uc.supplymgmtapi.service.AppUserService;
import com.uc.supplymgmtapi.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/login")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final AppUserService appUserService;

    private final RoleService roleService;
    private final JwtService jwtService;

    public AuthenticationController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, AppUserService appUserService, RoleService roleService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.appUserService = appUserService;
        this.roleService = roleService;
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> login(@RequestBody Login login) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(new TokenDTO(jwtService.generateToken(login.getEmail()), authentication.getAuthorities().toString()));
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    @GetMapping("/save")
    public void saveDummyUser() {
        Role roleUser = Role.builder().role("USER").build();
        Role roleAdmin = Role.builder().role("ADMIN").build();
        Role userWithRoleUser = roleService.save(roleUser);
        Role userWithRoleAdmin = roleService.save(roleAdmin);


        AppUser adminUser = AppUser.builder().email("narayan@email.com").password(passwordEncoder.encode("12345")).build();
        AppUser userUser = AppUser.builder().email("ashok@email.com").password(passwordEncoder.encode("12345")).build();
        adminUser.setRoles(Set.of(userWithRoleAdmin));
        userUser.setRoles(Set.of(userWithRoleUser));
        appUserService.save(adminUser);
        appUserService.save(userUser);
    }
}

