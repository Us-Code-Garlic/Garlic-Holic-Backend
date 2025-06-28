package com.garlicholic.backend.domain.batch;

import com.garlicholic.backend.storage.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import com.garlicholic.backend.storage.DementiaHistoryJpaRepository;
import com.garlicholic.backend.storage.UserEntity;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DailyReportTargetCollector {

    private final UserJpaRepository userJpaRepository;
    private final DementiaHistoryJpaRepository dementiaHistoryJpaRepository;

    public List<UserEntity> find() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDateTime yesterdayStart = yesterday.atStartOfDay();
        LocalDateTime yesterdayEnd = yesterday.atTime(LocalTime.MAX);

        List<Long> targetUserIds = dementiaHistoryJpaRepository.findDailyReportTargetUserIds(yesterdayStart, yesterdayEnd);

        return userJpaRepository.findAllById(targetUserIds);
    }

}
