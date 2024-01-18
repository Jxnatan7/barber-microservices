package com.barber.companyservice.dto.businessUnit.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BusinessUnitRequest {

    @NotNull
    private String zipCode;

    @NotNull
    private String street;

    @NotNull
    private String district;

    @NotNull
    private Integer number;

    @NotNull
    private String city;
}
