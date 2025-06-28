package com.garlicholic.backend.api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.garlicholic.backend.storage.ReportEntity;
import com.garlicholic.backend.storage.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReportResponse {
    private Long reportId;
    private String patientName;
    private LocalDateTime datetime;
    private String condition;
    private String healthStatus;

    @JsonProperty("isMedicine")
    private boolean medicine;
    private String memo;

    public static ReportResponse of(
            ReportEntity reportEntity,
            UserEntity targetUserEntity
    ) {
        return new ReportResponse(
                reportEntity.getId(),
                targetUserEntity.getName(),
                reportEntity.getCreatedAt(),
                reportEntity.getConditionText(),
                reportEntity.getHealthStatus(),
                reportEntity.getIsMedicine(),
                reportEntity.getMemo()
        );
    }

}
