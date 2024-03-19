package com.uc.supplymgmtapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private int Id;
    private String name;
    private Double quantity;
    private  Double price;


}
