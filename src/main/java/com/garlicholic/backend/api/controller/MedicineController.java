package com.garlicholic.backend.api.controller;

import com.garlicholic.backend.domain.MedicineCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medicine")
public class MedicineController {

    private final MedicineCoreService medicineCoreService;

    @PostMapping()
    public void append() {

    }

}
