package com.uc.supplymgmtapi.controller;

import com.uc.supplymgmtapi.dto.VendorDTO;
import com.uc.supplymgmtapi.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendors")
public class VendorController {
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    ResponseEntity<VendorDTO> add(@RequestBody VendorDTO vendorDTO){
        return ResponseEntity.ok(vendorService.save(vendorDTO));
    }
    @GetMapping
    ResponseEntity<List<VendorDTO>> findALl(){
        return ResponseEntity.ok(vendorService.findAll());
    }
    @DeleteMapping("/{productId}")
    public void deleteById(@PathVariable Long vendorId) {
        vendorService.deleteById(vendorId);
    }
}
