package com.uc.supplymgmtapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyInfoDTO {
    Long id;
    String name;
    String phone;
    String pan;
    String address;
}
