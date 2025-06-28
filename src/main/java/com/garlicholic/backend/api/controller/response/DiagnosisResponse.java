package com.garlicholic.backend.api.controller.response;

import lombok.Data;

@Data
public class DiagnosisResponse {
    private State state;
    private String nextAction;
}
