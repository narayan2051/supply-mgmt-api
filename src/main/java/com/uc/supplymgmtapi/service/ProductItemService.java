package com.uc.supplymgmtapi.service;

import com.uc.supplymgmtapi.dto.ProductItemDTO;
import com.uc.supplymgmtapi.entity.ProductItem;

import java.util.List;

public interface ProductItemService  extends GenericService<ProductItemDTO>{
   List<ProductItemDTO> findByProductId(Long productId);
}
