package com.garlicholic.backend.domain;

import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.api.gax.core.FixedCredentialsProvider;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class SpeechToTextService {

    public String transcribe(MultipartFile file) throws Exception {
        InputStream credentialsStream = new FileInputStream("src/main/resources/google-credentials.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream);
        SpeechSettings settings = SpeechSettings.newBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                .build();

        try (SpeechClient speechClient = SpeechClient.create(settings)) {

            byte[] audioBytes = file.getBytes();

            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.WEBM_OPUS)
                    .setLanguageCode("ko-KR")
                    .build();

            RecognitionAudio audio = RecognitionAudio.newBuilder()
                    .setContent(ByteString.copyFrom(audioBytes))
                    .build();

            RecognizeResponse response = speechClient.recognize(config, audio);
            StringBuilder resultText = new StringBuilder();

            for (SpeechRecognitionResult result : response.getResultsList()) {
                resultText.append(result.getAlternatives(0).getTranscript());
            }

            return resultText.toString();
        }
    }
}