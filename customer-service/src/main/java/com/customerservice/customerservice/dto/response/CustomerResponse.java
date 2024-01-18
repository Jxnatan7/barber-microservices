package com.customerservice.customerservice.dto.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private Integer id;
    private String token;
    private String name;
    private String email;
    private Double latitude;
    private Double longitude;
}