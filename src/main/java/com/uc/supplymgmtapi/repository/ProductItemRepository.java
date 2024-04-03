package com.uc.supplymgmtapi.repository;

import com.uc.supplymgmtapi.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    List<ProductItem> findByProductIdAndCompanyId(Long productId, Long companyId);
}
