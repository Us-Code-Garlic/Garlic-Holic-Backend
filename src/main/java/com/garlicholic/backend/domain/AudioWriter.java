package com.garlicholic.backend.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class AudioWriter {

    public String write(MultipartFile audioFile) throws IOException {
        String fileName = System.currentTimeMillis() + ".webm";
        Path uploadPath = Paths.get("/app/uploads/" + fileName);

        Files.createDirectories(uploadPath.getParent());
        Files.write(uploadPath, audioFile.getBytes());

        return fileName;
    }

}
