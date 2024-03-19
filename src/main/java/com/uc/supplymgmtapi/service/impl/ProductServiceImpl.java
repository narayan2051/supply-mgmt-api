package com.uc.supplymgmtapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uc.supplymgmtapi.dto.ProductDTO;
import com.uc.supplymgmtapi.entity.Product;
import com.uc.supplymgmtapi.repository.ProductRepository;
import com.uc.supplymgmtapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductDTO save(ProductDTO productDTO) {

        Product product = objectMapper.convertValue(productDTO, Product.class);

        return convertToDTO(productRepository.save(product));
    }

    private ProductDTO convertToDTO(Product product) {
        return objectMapper.convertValue(product, ProductDTO.class);
    }

    @Override
    public ProductDTO findById(String id) {
        return null;
    }

    @Override
    public List<ProductDTO> findAll() {
        return convertToDTOList(productRepository.findAll());
    }

    private List<ProductDTO> convertToDTOList(List<Product> products) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        products.forEach(product -> productDTOList.add(objectMapper.convertValue(product, ProductDTO.class)));
        return productDTOList;
    }

    @Override
    public void deleteById(String id) {

    }
}
