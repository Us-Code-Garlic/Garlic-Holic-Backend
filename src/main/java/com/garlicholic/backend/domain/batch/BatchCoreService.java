package com.garlicholic.backend.domain.batch;

import com.garlicholic.backend.domain.mail.MailCoreService;
import com.garlicholic.backend.domain.mail.ReportMailData;
import com.garlicholic.backend.storage.DementiaHistoryJpaRepository;
import com.garlicholic.backend.storage.UserEntity;
import com.garlicholic.backend.util.LocalDateFormatter;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BatchCoreService {

    private final MailCoreService mailCoreService;
    private final DailyReportTargetCollector dailyReportTargetCollector;

    @Scheduled(cron = "0 0 9 * * *")
    public void sendDailyReport() {
        List<UserEntity> userEntities = dailyReportTargetCollector.find();
        userEntities.forEach(userEntity -> {
            try {
                mailCoreService.sendMail(userEntity.getEmail(), new ReportMailData(
                        LocalDateFormatter.fromLocalDateTime(LocalDateTime.now().minusDays(1)),
                        "치매 의심",
                        "사유"
                ));
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
