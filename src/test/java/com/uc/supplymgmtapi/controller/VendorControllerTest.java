package com.uc.supplymgmtapi.controller;

import com.uc.supplymgmtapi.dto.VendorDTO;
import com.uc.supplymgmtapi.service.VendorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class VendorControllerTest {
    @Mock
    VendorService vendorService;
    @InjectMocks
    VendorController vendorController;
    VendorDTO vendorDTO= VendorDTO.builder().name("Ramesh Pasal").phone("9856171233").email("ramesh@gmail.com")
            .address("Irving TX").build();
    VendorDTO vendorDTOMock= VendorDTO.builder().name("Ramesh Pasal").phone("9856171233").email("ramesh@gmail.com")
            .address("Irving TX").build();

    @BeforeEach
    void setUp() {
        vendorDTO= VendorDTO.builder().name("Ramesh Pasal").phone("9856171233").email("ramesh@gmail.com")
                .address("Irving TX").build();
        vendorDTOMock= VendorDTO.builder().id(2L).name("Ramesh Pasal").phone("9856171233").email("ramesh@gmail.com")
                .address("Irving TX").build();
    }

    @Test
    void add() {
        Mockito.when(vendorService.save(vendorDTO)).thenReturn(vendorDTOMock);
        ResponseEntity<VendorDTO> actualResponse = vendorController.add(vendorDTO);
        VendorDTO actualVendorDTO = actualResponse.getBody();
        Assertions.assertEquals(HttpStatus.OK,actualResponse.getStatusCode());
        Assertions.assertEquals(vendorDTOMock.getName(),actualVendorDTO.getName());
        Assertions.assertEquals(vendorDTOMock.getPhone(), actualVendorDTO.getPhone());
        Assertions.assertEquals(vendorDTOMock.getEmail(), actualVendorDTO.getEmail());
        Assertions.assertEquals(vendorDTOMock.getAddress(), actualVendorDTO.getAddress());

    }

    @Test
    void findALl() {
        Mockito.when(vendorService.findAll()).thenReturn(List.of(vendorDTOMock));
        ResponseEntity<List<VendorDTO>> actualResponse = vendorController.findALl();
        Assertions.assertEquals(1, Objects.requireNonNull(actualResponse.getBody().size()));
    }

    @Test
    void deleteById() {
        Mockito.doNothing().when(vendorService).deleteById(1L);
    }
}