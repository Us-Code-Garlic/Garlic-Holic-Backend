package com.garlicholic.backend.api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class State {
    @JsonProperty("patient_id")
    private String patientId;

    @JsonProperty("dementia_result")
    private DementiaResult dementiaResult;

    @JsonProperty("medicine_result")
    private MedicineResult medicineResult;

    @JsonProperty("mood_result")
    private MoodResult moodResult;

    @JsonProperty("health_result")
    private HealthResult healthResult;
}
