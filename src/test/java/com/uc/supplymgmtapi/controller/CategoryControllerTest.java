package com.uc.supplymgmtapi.controller;

import com.uc.supplymgmtapi.dto.CategoryDTO;
import com.uc.supplymgmtapi.service.CategoryService;
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
class CategoryControllerTest {

    @Mock
    CategoryService categoryService;
    @InjectMocks
    CategoryController categoryController;
    CategoryDTO categoryDTO ;
    CategoryDTO categoryDTOMock ;

    @BeforeEach
    void setUp() {
        categoryDTO = CategoryDTO.builder().name("test").description("This is test").build();
        categoryDTOMock = CategoryDTO.builder().id(2L).name("test").description("This is test").build();

    }

    @Test
    void save() {
        Mockito.when(categoryService.save(categoryDTO)).thenReturn(categoryDTOMock);
        ResponseEntity<CategoryDTO> actualResponse = categoryController.save(categoryDTO);
        CategoryDTO actualDTO = actualResponse.getBody();
        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        Assertions.assertEquals(categoryDTOMock.getId(),actualDTO.getId());
        Assertions.assertEquals(categoryDTOMock.getName(), actualDTO.getName());
        Assertions.assertEquals(categoryDTOMock.getDescription(), actualDTO.getDescription());

    }

    @Test
    void findAll() {
        Mockito.when(categoryService.findAll()).thenReturn(List.of(categoryDTOMock));
        ResponseEntity<List<CategoryDTO>> actualResponse = categoryController.findAll();
        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        Assertions.assertEquals(1, Objects.requireNonNull(actualResponse.getBody().size()));
    }
}