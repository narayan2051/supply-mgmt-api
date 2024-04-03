package com.uc.supplymgmtapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uc.supplymgmtapi.dto.ProductItemDTO;
import com.uc.supplymgmtapi.entity.Category;
import com.uc.supplymgmtapi.entity.ProductItem;
import com.uc.supplymgmtapi.repository.ProductItemRepository;
import com.uc.supplymgmtapi.service.ProductItemService;
import com.uc.supplymgmtapi.util.AuthUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductItemServiceImpl implements ProductItemService {
    private final ProductItemRepository productItemRepository;
    private final AuthUtil authUtil;
    private ObjectMapper objectMapper = new ObjectMapper();

    public ProductItemServiceImpl(ProductItemRepository productItemRepository, AuthUtil authUtil) {
        this.productItemRepository = productItemRepository;
        this.authUtil = authUtil;
    }

    @Override
    public ProductItemDTO save(ProductItemDTO productItemDTO) {
        ProductItem productItem = convertToEntity(productItemDTO);
        return convertToDTO(productItemRepository.save(productItem));
    }

    private ProductItem convertToEntity(ProductItemDTO productItemDTO) {
        return ProductItem.builder().productId(productItemDTO.getProductId()).id(productItemDTO.getId())
                .name(productItemDTO.getName()).quantity(productItemDTO.getQuantity()).price(productItemDTO
                        .getPrice()).unit(productItemDTO.getUnit()).companyId(authUtil.getCompanyId()).build();
    }

    private ProductItemDTO convertToDTO(ProductItem productItem) {
        return ProductItemDTO.builder().productId(productItem.getProductId()).id(productItem.getId())
                .name(productItem.getName()).quantity(productItem.getQuantity()).price(productItem
                        .getPrice()).unit(productItem.getUnit()).build();
    }

    @Override
    public ProductItemDTO findById(Long id) {
        return null;
    }

    @Override
    public List<ProductItemDTO> findAll() {
        List<ProductItemDTO> productItemDTOList = new ArrayList<>();
        productItemRepository.findAll().forEach(productItem -> productItemDTOList.add(convertToDTO(productItem)));
        return productItemDTOList;
    }

    @Override
    public void deleteById(Long id) {
     productItemRepository.deleteById(id);
    }

    @Override
    public List<ProductItemDTO> findByProductId(Long productId) {
        return productItemRepository.findByProductIdAndCompanyId(productId,authUtil.getCompanyId()).stream().map(this::convertToDTO).toList();
    }
}
