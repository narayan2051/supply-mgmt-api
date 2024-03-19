package com.uc.supplymgmtapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uc.supplymgmtapi.dto.CategoryDTO;
import com.uc.supplymgmtapi.entity.Category;
import com.uc.supplymgmtapi.repository.CategoryRepository;
import com.uc.supplymgmtapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = objectMapper.convertValue(categoryDTO, Category.class);
        return objectMapper.convertValue(categoryRepository.save(category), CategoryDTO.class);
    }

    @Override
    public CategoryDTO findById(String id) {
        return null;
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> categoryDTOList.add(objectMapper.convertValue(category, CategoryDTO.class)));
        return categoryDTOList;
    }

    @Override
    public void deleteById(String id) {

    }
}
