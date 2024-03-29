package com.barber.companyservice.dto.haircut.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HaircutResponse {
    private String id;
    private String name;
    private BigDecimal price;
    private Boolean status;
    private Integer companyId;
}
