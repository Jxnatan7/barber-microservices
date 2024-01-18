package com.barber.companyservice.dto.company.response;

import com.barber.companyservice.dto.businessUnit.response.BusinessUnitResponse;
import lombok.Data;

@Data
public class CompanyResponse {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String cnpj;
    private BusinessUnitResponse businessUnit;
}
