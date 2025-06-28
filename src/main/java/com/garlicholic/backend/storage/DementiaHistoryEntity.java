package com.garlicholic.backend.storage;

import com.garlicholic.backend.api.controller.response.CheckResult;
import com.garlicholic.backend.api.controller.response.DiagnosisResponse;
import lombok.*;
import com.garlicholic.backend.domain.ChatResult;
import com.garlicholic.backend.domain.CheckDementiaResult;
import com.garlicholic.backend.util.LocalDateFormatter;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Entity
@Table(name = "dementia_history_tb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DementiaHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;

    @Column(columnDefinition = "TEXT")
    private String answer;

    @Column(columnDefinition = "TEXT")
    private String conversationAnalysis;

    @Column(columnDefinition = "TEXT")
    private String pronunciationClarity;

    @Column(columnDefinition = "TEXT")
    private String memoryRecall;

    @Column(columnDefinition = "TEXT")
    private String repetitiveSpeech;
    private LocalDateTime createdAt;
    private Boolean isDementia;

    public static DementiaHistoryEntity of(
            Long userId,
            DiagnosisResponse diagnosisResponse
    ) {
        List<CheckResult> checkResults = diagnosisResponse.getState().getDementiaResult().getCheckResults();

        return new DementiaHistoryEntity(
                userId,
                diagnosisResponse.getState().getDementiaResult().getContents(),
                checkResults.get(0).getDetails(),
                checkResults.get(1).getDetails(),
                checkResults.get(2).getDetails(),
                checkResults.get(3).getDetails(),
                LocalDateTime.now(),
                Objects.equals(diagnosisResponse.getState().getDementiaResult().getDiagnosis(), "yes")
        );
    }

    public DementiaHistoryEntity(Long userId, String answer, String conversationAnalysis, String pronunciationClarity, String memoryRecall, String repetitiveSpeech, LocalDateTime createdAt, Boolean isDementia) {
        this.userId = userId;
        this.answer = answer;
        this.conversationAnalysis = conversationAnalysis;
        this.pronunciationClarity = pronunciationClarity;
        this.memoryRecall = memoryRecall;
        this.repetitiveSpeech = repetitiveSpeech;
        this.createdAt = createdAt;
        this.isDementia = isDementia;
    }
}
