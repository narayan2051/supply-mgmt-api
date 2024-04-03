package com.uc.supplymgmtapi.controller.admin;

import com.uc.supplymgmtapi.dto.AppUserDTO;
import com.uc.supplymgmtapi.entity.AppUser;
import com.uc.supplymgmtapi.entity.CompanyInfo;
import com.uc.supplymgmtapi.entity.Role;
import com.uc.supplymgmtapi.service.AppUserService;
import com.uc.supplymgmtapi.service.CompanyInfoService;
import com.uc.supplymgmtapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/admin/users")
public class AppUserController {

    private final AppUserService appUserService;

    private final CompanyInfoService companyInfoService;

    private final RoleService roleService;

    @Autowired
    public AppUserController(AppUserService appUserService, CompanyInfoService companyInfoService, RoleService roleService) {
        this.appUserService = appUserService;
        this.companyInfoService = companyInfoService;
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<AppUserDTO> save(@RequestBody AppUserDTO appUserDTO) {
        if (null != appUserDTO) {
           Role role= roleService.findByRoleName("USER");
            CompanyInfo companyInfo= companyInfoService.findById(appUserDTO.getCompanyId());
            AppUser appUser = AppUser.builder().email(appUserDTO.getEmail())
                    .phone(appUserDTO.getPhone()).firstName(appUserDTO.getFirstName()).lastName(appUserDTO.getLastName())
                    .company(companyInfo).build();
            appUser.setRoles(Set.of(role));
            appUserService.save(appUser);
            appUserDTO.setId(appUser.getId());
            return ResponseEntity.ok(appUserDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<AppUserDTO>> findListOfUsersByCompanyId(@PathVariable String companyId){
       return ResponseEntity.ok(appUserService.findAllUserByCompanyId(companyId));
    }

}
