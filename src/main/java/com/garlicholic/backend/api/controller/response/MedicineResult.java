package com.garlicholic.backend.api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MedicineResult {
    private String time;

    @JsonProperty("medicine_name")
    private String medicineName;

    private String dosage;

    @JsonProperty("needs_reminder")
    private boolean needsReminder;
}
