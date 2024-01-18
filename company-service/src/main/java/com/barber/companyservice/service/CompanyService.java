package com.barber.companyservice.service;

import com.barber.companyservice.dto.businessUnit.response.BusinessUnitResponse;
import com.barber.companyservice.dto.company.request.CompanyRequest;
import com.barber.companyservice.dto.company.response.CompanyResponse;
import com.barber.companyservice.exceptions.EmailException;
import com.barber.companyservice.model.BusinessUnit;
import com.barber.companyservice.model.Company;
import com.barber.companyservice.repository.BusinessUnitRepository;
import com.barber.companyservice.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final BusinessUnitRepository businessUnitRepository;

    @Autowired
    private PasswordEncoder encoder;

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public BusinessUnit saveBusinessUnit(BusinessUnit businessUnit) {
        return businessUnitRepository.save(businessUnit);
    }

    public CompanyResponse createCompany(CompanyRequest companyRequest) {
        if (Boolean.TRUE.equals(companyRepository.existsByEmail(companyRequest.getEmail()))) {
            throw new EmailException();
        }

        var company = new Company();
        BeanUtils.copyProperties(companyRequest, company);

        var businessUnit = new BusinessUnit();
        BeanUtils.copyProperties(companyRequest.getBusinessUnit(), businessUnit);

        businessUnit.setCompany(save(company));
        saveBusinessUnit(businessUnit);
        return convertToCompanyResponse(company, businessUnit);
    }

    private CompanyResponse convertToCompanyResponse(Company company, BusinessUnit businessUnit) {
        var companyResponse = new CompanyResponse();
        BeanUtils.copyProperties(company, companyResponse);
        companyResponse.setBusinessUnit(convertToBusinessUnitResponse(businessUnit));
        return companyResponse;
    }

    private BusinessUnitResponse convertToBusinessUnitResponse(BusinessUnit businessUnit) {
        var businessUnitResponse = new BusinessUnitResponse();
        BeanUtils.copyProperties(businessUnit, businessUnitResponse);
        return businessUnitResponse;
    }
}