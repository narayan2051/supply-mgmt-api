package com.uc.supplymgmtapi.controller;

import com.uc.supplymgmtapi.dto.ProductDTO;
import com.uc.supplymgmtapi.service.ProductService;
import com.uc.supplymgmtapi.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> add(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.save(productDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }


}
