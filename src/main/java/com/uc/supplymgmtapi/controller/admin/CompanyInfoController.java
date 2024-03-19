package com.uc.supplymgmtapi.controller.admin;

import com.uc.supplymgmtapi.entity.CompanyInfo;
import com.uc.supplymgmtapi.service.CompanyInfoService;
import com.uc.supplymgmtapi.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/company-infos")
public class CompanyInfoController {

    private final CompanyInfoService companyInfoService;

    @Autowired
    public CompanyInfoController(CompanyInfoService companyInfoService) {
        this.companyInfoService = companyInfoService;
    }

    @PostMapping
    public ResponseEntity<CompanyInfo> save(@RequestBody CompanyInfo companyInfo) {
        return ResponseEntity.ok(companyInfoService.save(companyInfo));
    }

    public ResponseEntity<CompanyInfo> findById(String id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<CompanyInfo>> findAll() {
        return ResponseEntity.ok(companyInfoService.findAll());
    }

    public void deleteById(String id) {

    }
}


