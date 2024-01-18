package com.barber.companyservice.dto.businessUnit.response;

import lombok.Data;

@Data
public class BusinessUnitResponse {
    private String zipCode;
    private String street;
    private String district;
    private Integer number;
    private String city;
}
