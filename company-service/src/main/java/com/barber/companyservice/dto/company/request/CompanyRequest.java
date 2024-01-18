package com.barber.companyservice.dto.company.request;

import com.barber.companyservice.dto.businessUnit.request.BusinessUnitRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {

    @NotNull
    private String name;

    @Email
    private String email;

    @NotNull
    private String password;

    @CPF
    private String cpf;

    @CNPJ
    private String cnpj;

    @NotNull
    private BusinessUnitRequest businessUnit;
}
