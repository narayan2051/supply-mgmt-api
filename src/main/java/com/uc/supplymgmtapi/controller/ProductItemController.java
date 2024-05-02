package com.uc.supplymgmtapi.controller;

import com.uc.supplymgmtapi.dto.CategoryDTO;
import com.uc.supplymgmtapi.dto.ProductItemDTO;
import com.uc.supplymgmtapi.service.ProductItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productItem")
public class ProductItemController {
    private final ProductItemService productItemService;

    public ProductItemController(ProductItemService productItemService) {
        this.productItemService = productItemService;
    }
    @PostMapping
    public ResponseEntity<ProductItemDTO> save(@RequestBody ProductItemDTO productItemDTO) {
        return ResponseEntity.ok(productItemService.save(productItemDTO));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductItemDTO>> findByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(productItemService.findByProductId(productId));
    }
    @DeleteMapping("/{productId}")
    public void deleteById(@PathVariable Long productId) {
        productItemService.deleteById(productId);
    }
}
