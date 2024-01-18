package com.barber.companyservice.service;

import com.barber.companyservice.dto.haircut.request.HaircutRequest;
import com.barber.companyservice.dto.haircut.response.HaircutResponse;
import com.barber.companyservice.exceptions.NotFoundException;
import com.barber.companyservice.model.Company;
import com.barber.companyservice.model.Haircut;
import com.barber.companyservice.repository.CompanyRepository;
import com.barber.companyservice.repository.HaircutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HaircutService {

    private final HaircutRepository haircutRepository;
    private final CompanyRepository companyRepository;

    public void createHaircut(HaircutRequest haircutRequest) {
        Company company = companyRepository.findById(haircutRequest.getCompanyId()).orElseThrow(NotFoundException::new);

        Haircut haircut = Haircut.builder()
                .name(haircutRequest.getName())
                .price(haircutRequest.getPrice())
                .status(haircutRequest.getStatus())
                .companyId(company.getId())
                .build();

        haircutRepository.save(haircut);
    }

    public List<HaircutResponse> getAllHaircuts() {
        List<Haircut> haircuts = haircutRepository.findAll();
        return haircuts.stream().map(this::mapToHaircutResponse).toList();
    }

    public void updateHaircut(String haircutId, HaircutRequest haircutRequest) {
        Haircut haircut = haircutRepository.findById(haircutId).orElseThrow(NotFoundException::new);
        BeanUtils.copyProperties(haircutRequest, haircut);
        haircutRepository.save(haircut);
    }

    private HaircutResponse mapToHaircutResponse(Haircut haircut) {
        var response = new HaircutResponse();
        BeanUtils.copyProperties(haircut, response);
        return response;
    }

    public HaircutResponse detailHaircut(String haircutId) {
        Haircut haircut = haircutRepository.findById(haircutId).orElseThrow(NotFoundException::new);
        return mapToHaircutResponse(haircut);
    }
}
