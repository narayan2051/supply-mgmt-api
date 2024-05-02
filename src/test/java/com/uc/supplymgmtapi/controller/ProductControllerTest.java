package com.uc.supplymgmtapi.controller;

import com.uc.supplymgmtapi.dto.ProductDTO;
import com.uc.supplymgmtapi.service.impl.ProductServiceImpl;
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
class ProductControllerTest {

    @Mock
    ProductServiceImpl productService;

    @InjectMocks
    ProductController productController;

    ProductDTO productDTO;
    ProductDTO productDTOMock;

    @BeforeEach
    void setup() {
        productDTO = ProductDTO.builder().categoryId(12L).name("Test Product").code("1234jdhf").build();
        productDTOMock = ProductDTO.builder().id(1L).categoryId(12L).name("Test Product").code("1234jdhf").build();

    }

    @Test
    void add() {
        Mockito.when(productService.save(productDTO)).thenReturn(productDTOMock);
        ResponseEntity<ProductDTO> actualResponse = productController.add(productDTO);
        ProductDTO actualDTO = actualResponse.getBody();
        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        Assertions.assertEquals(productDTOMock.getId(), actualDTO.getId());
        Assertions.assertEquals(productDTOMock.getCategoryId(), actualDTO.getCategoryId());
        Assertions.assertEquals(productDTOMock.getName(), actualDTO.getName());
        Assertions.assertEquals(productDTOMock.getCode(), actualDTO.getCode());


    }

    @Test
    void findAll() {
        Mockito.when(productService.findAll()).thenReturn(List.of(productDTOMock));

        ResponseEntity<List<ProductDTO>> actualResponse= productController.findAll();
        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        Assertions.assertEquals(1, Objects.requireNonNull(actualResponse.getBody()).size());




    }
}