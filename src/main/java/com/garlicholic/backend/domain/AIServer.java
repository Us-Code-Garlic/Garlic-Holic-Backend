package com.garlicholic.backend.domain;

import com.garlicholic.backend.api.controller.response.DiagnosisResponse;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;

@Component
public class AIServer {

    private final String AI_SERVER_HOST = "http://13.209.146.78:8000";

    public DiagnosisResponse postCheckDementia(String text, File wavFile) {
        WebClient webClient = WebClient.create(AI_SERVER_HOST);

        MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();
        formData.add("patient_id", "patient_001");
        formData.add("message", text);
        formData.add("audio_file", new FileSystemResource(wavFile));

        return webClient.post()
                .uri("/supervisor")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(formData))
                .retrieve()
                .bodyToMono(DiagnosisResponse.class)
                .block();
    }

    public SummarizeResult postSummery(String text) {
        return WebClient.create("http://13.209.146.78:8001").post()
                .uri("/summarize")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new SummarizeRequest(text)))
                .retrieve()
                .bodyToMono(SummarizeResult.class)
                .block();
    }


}
