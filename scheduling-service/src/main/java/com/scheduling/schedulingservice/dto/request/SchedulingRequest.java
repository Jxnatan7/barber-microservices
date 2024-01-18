package com.scheduling.schedulingservice.dto.request;

import java.time.LocalDateTime;

public record SchedulingRequest(String userId, String companyId, String haircutId, LocalDateTime dateTime) {

}
