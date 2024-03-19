package com.uc.supplymgmtapi.service.impl;

import com.uc.supplymgmtapi.entity.CompanyInfo;
import com.uc.supplymgmtapi.repository.CompanyInfoRepository;
import com.uc.supplymgmtapi.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    private final CompanyInfoRepository companyInfoRepository;

    @Autowired
    public CompanyInfoServiceImpl(CompanyInfoRepository companyInfoRepository) {
        this.companyInfoRepository = companyInfoRepository;
    }

    @Override
    public CompanyInfo save(CompanyInfo companyInfo) {
        return companyInfoRepository.save(companyInfo);
    }

    @Override
    public CompanyInfo findById(String id) {
        return null;
    }

    @Override
    public List<CompanyInfo> findAll() {
        return companyInfoRepository.findAll();
    }

    @Override
    public void deleteById(String id) {

    }
}
