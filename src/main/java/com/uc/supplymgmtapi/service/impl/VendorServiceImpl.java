package com.uc.supplymgmtapi.service.impl;

import com.uc.supplymgmtapi.dto.ProductDTO;
import com.uc.supplymgmtapi.dto.VendorDTO;
import com.uc.supplymgmtapi.entity.Vendor;
import com.uc.supplymgmtapi.repository.VendorRepository;
import com.uc.supplymgmtapi.service.VendorService;
import com.uc.supplymgmtapi.util.AuthUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VendorServiceImpl implements VendorService {
    private final VendorRepository vendorRepository;
    private final AuthUtil authUtil;

    public VendorServiceImpl(VendorRepository vendorRepository, AuthUtil authUtil) {
        this.vendorRepository = vendorRepository;
        this.authUtil = authUtil;
    }

    @Override
    public VendorDTO save(VendorDTO vendorDTO) {
        Vendor vendor = convertFromDTO(vendorDTO);
        return convertToDTO(vendorRepository.save(vendor));
    }

    private VendorDTO convertToDTO(Vendor vendor) {
        return VendorDTO.builder().id(vendor.getId()).name(vendor.getName()).phone(vendor.getPhone()).email(vendor
                .getEmail()).address(vendor.getAddress()).build();
    }

    private Vendor convertFromDTO(VendorDTO vendorDTO) {
        return Vendor.builder().id(vendorDTO.getId()).name(vendorDTO.getName()).email(vendorDTO.getEmail())
                .phone(vendorDTO.getPhone()).companyId(authUtil.getCompanyId()).address(vendorDTO.getAddress()).build();
    }

    @Override
    public VendorDTO findById(Long id) {
        return null;
    }

    @Override
    public List<VendorDTO> findAll() {
        return convertToDTOList(vendorRepository.findByCompanyId(authUtil.getCompanyId()));
    }

    private List<VendorDTO> convertToDTOList(List<Vendor> vendors) {
        List<VendorDTO> vendorDTOList = new ArrayList<>();
        vendors.forEach(vendor-> {
            vendorDTOList.add(convertToDTO(vendor));
        });
        return vendorDTOList;
    }

    @Override
    public void deleteById(Long id) {
        vendorRepository.deleteById(id);

    }
}
