package com.uc.supplymgmtapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uc.supplymgmtapi.dto.CategoryDTO;
import com.uc.supplymgmtapi.entity.Category;
import com.uc.supplymgmtapi.repository.CategoryRepository;
import com.uc.supplymgmtapi.service.CategoryService;
import com.uc.supplymgmtapi.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final AuthUtil authUtil;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, AuthUtil authUtil) {
        this.categoryRepository = categoryRepository;
        this.authUtil = authUtil;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = convertToEntity(categoryDTO);
        return convertToDTO(categoryRepository.save(category));
    }

    private CategoryDTO convertToDTO(Category categoryEntity) {
        return CategoryDTO.builder().id(categoryEntity.getId())
                .name(categoryEntity.getName()).description(categoryEntity.getDescription()).build();
    }

    private Category convertToEntity(CategoryDTO categoryDTO) {
        Category category = Category.builder().id(categoryDTO.getId())
                .name(categoryDTO.getName()).description(categoryDTO.getDescription()).build();
        category.setCompanyId(authUtil.getCompanyId());
        return category;
    }

    @Override
    public CategoryDTO findById(Long id) {
        return null;
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        categoryRepository.findByCompanyId(authUtil.getCompanyId()).forEach(category -> categoryDTOList.add(convertToDTO(category)));
        return categoryDTOList;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Category> findByCategoryId(Long id) {
        return categoryRepository.findById(id);
    }
}
