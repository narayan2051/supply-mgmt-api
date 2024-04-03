package com.uc.supplymgmtapi.service.impl;

import com.uc.supplymgmtapi.dto.ProductDTO;
import com.uc.supplymgmtapi.entity.Category;
import com.uc.supplymgmtapi.entity.Product;
import com.uc.supplymgmtapi.exceptions.CategoryNotFoundException;
import com.uc.supplymgmtapi.repository.ProductRepository;
import com.uc.supplymgmtapi.service.CategoryService;
import com.uc.supplymgmtapi.service.ProductService;
import com.uc.supplymgmtapi.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final AuthUtil authUtil;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, AuthUtil authUtil) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.authUtil = authUtil;
    }


    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = convertFromDTO(productDTO);
        Optional<Category> category = categoryService.findByCategoryId(productDTO.getCategoryId());
        if (category.isPresent())
            product.setCategory(category.get());
        else
            throw new CategoryNotFoundException("Category not found");
        return convertToDTO(productRepository.save(product));
    }

    private Product convertFromDTO(ProductDTO productDTO) {
        return Product.builder().name(productDTO.getName()).id(productDTO.getId()).companyId(authUtil.getCompanyId()).build();
    }

    private ProductDTO convertToDTO(Product product) {
        return ProductDTO.builder().name(product.getName())
                .id(product.getId()).categoryId(product.getCategory().getId()).build();
    }

    @Override
    public ProductDTO findById(Long id) {
        return null;
    }

    @Override
    public List<ProductDTO> findAll() {
        return convertToDTOList(productRepository.findByCompanyId(authUtil.getCompanyId()));
    }

    private List<ProductDTO> convertToDTOList(List<Product> products) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        products.forEach(product -> {
            productDTOList.add(convertToDTO(product));
        });
        return productDTOList;
    }

    @Override
    public void deleteById(Long id) {

    }
}
