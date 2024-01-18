package com.barber.companyservice.controller;

import com.barber.companyservice.dto.company.request.CompanyRequest;
import com.barber.companyservice.dto.company.response.CompanyResponse;
import com.barber.companyservice.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
@Slf4j
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CompanyResponse> createCompany(@RequestBody CompanyRequest companyRequest) {
        var createdCompany = companyService.createCompany(companyRequest);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }

}
