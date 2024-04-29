package com.uc.supplymgmtapi.repository;

import com.uc.supplymgmtapi.entity.Product;
import com.uc.supplymgmtapi.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    List<Vendor> findByCompanyId(Long companyId);
}
