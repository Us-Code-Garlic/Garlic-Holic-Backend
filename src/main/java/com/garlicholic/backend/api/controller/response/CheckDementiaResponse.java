package com.garlicholic.backend.api.controller.response;

import lombok.Getter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CheckDementiaResponse {

    private String answer;

    @JsonProperty("isDementia")
    private boolean dementia;

    public static CheckDementiaResponse of(
            DiagnosisResponse diagnosisResponse
    ) {
        return new CheckDementiaResponse(
                diagnosisResponse.getState().getDementiaResult().getContents(),
                Objects.equals(diagnosisResponse.getState().getDementiaResult().getDiagnosis(), "yes")
        );
    }

}