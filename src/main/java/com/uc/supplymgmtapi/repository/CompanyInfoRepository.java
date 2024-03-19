package com.uc.supplymgmtapi.repository;

import com.uc.supplymgmtapi.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyInfoRepository extends JpaRepository<CompanyInfo,String> {
}
