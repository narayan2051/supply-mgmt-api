package com.uc.supplymgmtapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "APP_USER")
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String email;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
