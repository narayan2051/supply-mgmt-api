package com.uc.supplymgmtapi.repository;

import com.uc.supplymgmtapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> findByCompanyId(Long companyId);
}
