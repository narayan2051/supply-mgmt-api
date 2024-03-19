package com.uc.supplymgmtapi.controller;

import com.uc.supplymgmtapi.dto.CategoryDTO;
import com.uc.supplymgmtapi.dto.ProductDTO;
import com.uc.supplymgmtapi.service.CategoryService;
import com.uc.supplymgmtapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.save(categoryDTO));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }
}
