package com.scheduling.schedulingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(value = "scheduling")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Scheduling {
    private String id;
    private String userId;
    private String companyId;
    private String haircutId;
    private LocalDateTime dateTime;
}
