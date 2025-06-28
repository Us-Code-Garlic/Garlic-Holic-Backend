package com.garlicholic.backend.api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CheckResult {
    private String type;
    private Double confidence; // 일부 없음 → nullable
    private String details;

    @JsonProperty("sub_analyses")
    private List<SubAnalysis> subAnalyses; // 일부 항목만 포함
}
