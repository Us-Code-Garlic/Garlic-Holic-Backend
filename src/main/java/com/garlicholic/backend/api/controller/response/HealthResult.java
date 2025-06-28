package com.garlicholic.backend.api.controller.response;

import lombok.Data;

@Data
public class HealthResult {
    private String status;
    private double confidence;
}
