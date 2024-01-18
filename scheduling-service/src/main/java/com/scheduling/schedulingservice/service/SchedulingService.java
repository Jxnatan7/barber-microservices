package com.scheduling.schedulingservice.service;

import com.scheduling.schedulingservice.dto.request.SchedulingRequest;
import com.scheduling.schedulingservice.dto.response.SchedulingResponse;
import com.scheduling.schedulingservice.exceptions.NotFoundException;
import com.scheduling.schedulingservice.model.Scheduling;
import com.scheduling.schedulingservice.repository.SchedulingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchedulingService {
    private final SchedulingRepository schedulingRepository;
    private final WebClient webClient;

    public void createScheduling(SchedulingRequest schedulingRequest) {
        Scheduling scheduling = Scheduling.builder()
                .userId(schedulingRequest.userId())
                .companyId(schedulingRequest.companyId())
                .haircutId(schedulingRequest.haircutId())
                .dateTime(schedulingRequest.dateTime())
                .build();

        schedulingRepository.save(scheduling);
    }

    public List<SchedulingResponse> getAllSchedulings() {
        List<Scheduling> scheduling = schedulingRepository.findAll();
        return scheduling.stream().map(this::mapToSchedulingResponse).toList();
    }

    public void updateScheduling(String schedulingId, SchedulingRequest schedulingRequest) {
        Scheduling scheduling = schedulingRepository.findById(schedulingId).orElseThrow(NotFoundException::new);
        BeanUtils.copyProperties(schedulingRequest, scheduling);
        schedulingRepository.save(scheduling);
    }

    private SchedulingResponse mapToSchedulingResponse(Scheduling scheduling) {
        var response = new SchedulingResponse();
        BeanUtils.copyProperties(scheduling, response);
        return response;
    }

    public SchedulingResponse detailScheduling(String schedulingId) {
        Scheduling scheduling = schedulingRepository.findById(schedulingId).orElseThrow(NotFoundException::new);
        return mapToSchedulingResponse(scheduling);
    }
}
