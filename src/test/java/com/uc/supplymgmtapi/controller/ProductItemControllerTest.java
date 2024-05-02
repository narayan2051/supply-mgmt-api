package com.uc.supplymgmtapi.controller;

import com.uc.supplymgmtapi.dto.ProductItemDTO;
import com.uc.supplymgmtapi.service.ProductItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class ProductItemControllerTest {
    @Mock
    ProductItemService productItemService;
    @InjectMocks
    ProductItemController productItemController;
    ProductItemDTO productItemDTO =ProductItemDTO.builder().name("Rice").productId(60L).price(45.36).quantity(12.0).unit("test").build();
    ProductItemDTO productItemDTOMock =ProductItemDTO.builder().id(100L).name("Rice").productId(60L).price(45.36).quantity(12.0).unit("test").build();

    @BeforeEach
    void setUp() {
        productItemDTO =ProductItemDTO.builder().name("Rice").productId(60L).price(45.36).quantity(12.0).unit("test").build();
        productItemDTOMock =ProductItemDTO.builder().id(100L).name("Rice").productId(60L).price(45.36).quantity(12.0).unit("test").build();

    }

    @Test
    void save() {
        Mockito.when(productItemService.save(productItemDTO)).thenReturn(productItemDTOMock);
        ResponseEntity<ProductItemDTO> actualResponse = productItemController.save(productItemDTO);
        ProductItemDTO actualDTO = actualResponse.getBody();
        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        Assertions.assertEquals(productItemDTOMock.getName(),actualDTO.getName());
        Assertions.assertEquals(productItemDTOMock.getProductId(),actualDTO.getProductId());
        Assertions.assertEquals(productItemDTOMock.getPrice(),actualDTO.getPrice());
        Assertions.assertEquals(productItemDTOMock.getQuantity(),actualDTO.getQuantity());
        Assertions.assertEquals(productItemDTOMock.getUnit(),actualDTO.getUnit());
    }

    @Test
    void findByProductId() {
        Mockito.when(productItemService.findByProductId(60L)).thenReturn(List.of(productItemDTOMock));
        ResponseEntity<List<ProductItemDTO>> actualResponse = productItemController.findByProductId(60L);
        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        Assertions.assertEquals(1, Objects.requireNonNull(actualResponse.getBody().size()));
    }

    @Test
    void deleteById() {
        Mockito.doNothing().when(productItemService).deleteById(100L);
    }
}