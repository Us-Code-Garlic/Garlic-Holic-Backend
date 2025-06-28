package com.garlicholic.backend.api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DementiaResult {
    private String diagnosis;
    private double confidence;
    private String contents;

    @JsonProperty("check_results")
    private List<CheckResult> checkResults;
}
