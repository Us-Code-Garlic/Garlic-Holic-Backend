package com.garlicholic.backend.api.controller;

import com.garlicholic.backend.api.support.ApiResponse;
import com.garlicholic.backend.domain.AIServer;
import com.garlicholic.backend.domain.ReportCoreService;
import com.garlicholic.backend.domain.SummarizeResult;
import com.garlicholic.backend.domain.mail.MailCoreService;
import com.garlicholic.backend.domain.mail.ReportMailData;
import com.garlicholic.backend.storage.DementiaHistoryEntity;
import com.garlicholic.backend.storage.DementiaHistoryJpaRepository;
import com.garlicholic.backend.storage.ReportJpaRepository;
import com.garlicholic.backend.util.LocalDateFormatter;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MailController {

    private final AIServer aiServer;
    private final MailCoreService mailCoreService;
    private final DementiaHistoryJpaRepository  dementiaHistoryJpaRepository;

    @GetMapping("/mail")
    public ApiResponse<?> sendMail() throws MessagingException, UnsupportedEncodingException {
        String text = concatTodayFields(1L);
        SummarizeResult result = aiServer.postSummery(text);
        ReportMailData reportMailData = new ReportMailData(
                LocalDateFormatter.fromLocalDateTime(LocalDateTime.now()),
                result.isDementia_suspicion() ? "치매 의심" : "정상",
                result.getSummary());
        mailCoreService.sendMail("bananana0118@gmail.com", reportMailData);
        log.info("Mail sent successfully");
        return ApiResponse.success(null);
    }

    private String concatTodayFields(Long userId) {
        LocalDateTime todayStart = LocalDate.now().atStartOfDay();
        LocalDateTime todayEnd = LocalDate.now().atTime(LocalTime.MAX);

        List<DementiaHistoryEntity> histories = dementiaHistoryJpaRepository
                .findAllByUserIdAndCreatedAtBetween(userId, todayStart, todayEnd);

        return histories.stream()
                .map(h -> String.join(" ",
                        h.getConversationAnalysis(),
                        h.getPronunciationClarity(),
                        h.getMemoryRecall(),
                        h.getRepetitiveSpeech()))
                .reduce("", (a, b) -> a + " " + b)
                .trim();
    }

}
