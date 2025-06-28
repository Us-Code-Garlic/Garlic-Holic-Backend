package com.garlicholic.backend.domain.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReportMailData {

    private String targetDateText; // Format: yyyy년 MM월 dd일
    private String dementiaStatusText; // 치매 의심 | 정상 등
    private String diagnosisReasonText; // 진단 사유

}
