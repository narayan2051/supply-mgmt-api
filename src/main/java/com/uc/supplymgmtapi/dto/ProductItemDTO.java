package com.uc.supplymgmtapi.dto;

import com.uc.supplymgmtapi.entity.Category;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductItemDTO {

    Long id;
    String name;
    Long productId;
    Double price;
    Double quantity;
    String unit;

}
