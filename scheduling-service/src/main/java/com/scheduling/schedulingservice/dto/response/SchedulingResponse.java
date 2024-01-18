package com.scheduling.schedulingservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingResponse {
    String id;
    String userId;
    String companyId;
    String haircutId;
    LocalDateTime dateTime;
}
