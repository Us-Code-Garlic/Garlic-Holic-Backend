package com.garlicholic.backend.api.controller.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.List;

@Data
public class SubAnalysis {
    private String type;
    private double confidence;

    @JsonDeserialize(using = SafeStringListDeserializer.class)
    private List<String> details;
}
