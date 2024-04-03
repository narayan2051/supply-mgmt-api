package com.uc.supplymgmtapi.repository;

import com.uc.supplymgmtapi.dto.AppUserDTO;
import com.uc.supplymgmtapi.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyInfoRepository extends JpaRepository<CompanyInfo,Long> {
}
