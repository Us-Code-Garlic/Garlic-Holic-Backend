package com.garlicholic.backend.domain;

import com.garlicholic.backend.api.controller.response.DiagnosisResponse;
import com.garlicholic.backend.storage.DementiaHistoryEntity;
import com.garlicholic.backend.storage.DementiaHistoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@RequiredArgsConstructor
public class VoiceCoreService {

    private final AIServer aiServer;
    private final ReportCoreService reportCoreService;
    private final SpeechToTextService speechToTextService;
    private final AudioConvertor audioConvertor;
    private final AudioWriter audioWriter;

    private final DementiaHistoryJpaRepository dementiaHistoryJpaRepository;

    public DiagnosisResponse chat(MultipartFile audioFile) throws Exception {
        String text = speechToTextService.transcribe(audioFile);
        String fileName = audioWriter.write(audioFile);
        File wavFile = audioConvertor.convertWebmToWav(fileName);

        DiagnosisResponse diagnosisResponse = aiServer.postCheckDementia(text, wavFile);
        dementiaHistoryJpaRepository.save(DementiaHistoryEntity.of(1L, diagnosisResponse));

        reportCoreService.create(
                diagnosisResponse.getState().getHealthResult().getStatus(),
                diagnosisResponse.getState().getMoodResult().getMood()
        );

        return diagnosisResponse;
    }



}
