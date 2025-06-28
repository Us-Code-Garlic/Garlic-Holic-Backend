package com.garlicholic.backend.api.controller;

import com.garlicholic.backend.api.controller.response.ReportResponse;
import com.garlicholic.backend.api.support.ApiResponse;
import com.garlicholic.backend.storage.ReportJpaRepository;
import lombok.RequiredArgsConstructor;
import com.garlicholic.backend.domain.ReportCoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportCoreService reportCoreService;

    @GetMapping()
    public ApiResponse<List<ReportResponse>> readAll() {
        List<ReportResponse> reportResponses = reportCoreService.readAll(1L);
        return ApiResponse.success(reportResponses);
    }

}
