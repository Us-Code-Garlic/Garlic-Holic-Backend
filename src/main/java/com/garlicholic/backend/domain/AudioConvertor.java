package com.garlicholic.backend.domain;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class AudioConvertor {

    public File convertWebmToWav(String fileName) throws IOException, InterruptedException {
        File inputFile = new File("uploads/" + fileName);
        File outputFile = new File("outputs/" + fileName + ".wav");

        ProcessBuilder builder = new ProcessBuilder(
                "ffmpeg",
                "-loglevel", "quiet",
                "-y",
                "-i", inputFile.getAbsolutePath(),
                outputFile.getAbsolutePath()
        );
        builder.redirectOutput(ProcessBuilder.Redirect.DISCARD);
        builder.redirectError(ProcessBuilder.Redirect.DISCARD);

        Process process = builder.start();
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            inputFile.delete();
            System.out.println("변환 완료: " + outputFile.getAbsolutePath());
        } else {
            System.err.println("FFmpeg 변환 실패");
        }

        return outputFile;
    }

}
