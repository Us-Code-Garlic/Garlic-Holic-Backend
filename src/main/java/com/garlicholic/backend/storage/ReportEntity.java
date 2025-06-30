package com.garlicholic.backend.storage;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.N;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "report_tb")
@AllArgsConstructor
@NoArgsConstructor
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String conditionText;
    private String healthStatus;
    private Boolean isMedicine;
    private String quizScore;
    private String memo;
    private LocalDateTime createdAt;

    public void updateHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public void updateConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    public ReportEntity(Long userId, String conditionText, String healthStatus, Boolean isMedicine, String quizScore, String memo, LocalDateTime createdAt) {
        this.userId = userId;
        this.conditionText = conditionText;
        this.healthStatus = healthStatus;
        this.isMedicine = isMedicine;
        this.quizScore = quizScore;
        this.memo = memo;
        this.createdAt = createdAt;
    }
}
