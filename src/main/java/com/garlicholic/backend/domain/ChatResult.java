package com.garlicholic.backend.domain;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@Setter
@Getter
public class ChatResult {
    @JsonProperty("patient_id")
    private String patientId;

    @JsonProperty("final_diagnosis")
    private String finalDiagnosis;

    @JsonProperty("check_results")
    private List<CheckDementiaResult> checkResults;

    private String timestamp;
    private String contents;
}
