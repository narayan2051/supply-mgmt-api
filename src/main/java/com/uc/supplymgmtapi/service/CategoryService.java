package com.uc.supplymgmtapi.service;

import com.uc.supplymgmtapi.dto.CategoryDTO;
import com.uc.supplymgmtapi.entity.Category;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface CategoryService extends GenericService<CategoryDTO> {
    Optional<Category> findByCategoryId(Long id);
}
