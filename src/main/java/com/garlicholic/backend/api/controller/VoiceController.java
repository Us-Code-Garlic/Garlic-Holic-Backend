package com.garlicholic.backend.api.controller;

import com.garlicholic.backend.api.controller.response.DiagnosisResponse;
import lombok.RequiredArgsConstructor;
import com.garlicholic.backend.api.controller.response.CheckDementiaResponse;
import com.garlicholic.backend.api.support.ApiResponse;
import com.garlicholic.backend.domain.ChatResult;
import com.garlicholic.backend.domain.VoiceCoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class VoiceController {

    private final VoiceCoreService voiceCoreService;

    @PostMapping("/voice-chat")
    public ApiResponse<?> handleAudioUpload(@RequestParam("audio") MultipartFile audioFile) throws Exception {
        DiagnosisResponse diagnosisResponse = voiceCoreService.chat(audioFile);
        return ApiResponse.success(CheckDementiaResponse.of(diagnosisResponse));
    }

}
