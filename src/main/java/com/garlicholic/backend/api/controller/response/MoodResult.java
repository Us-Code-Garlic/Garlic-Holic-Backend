package com.garlicholic.backend.api.controller.response;

import lombok.Data;

@Data
public class MoodResult {
    private String mood;
    private double confidence;
}
