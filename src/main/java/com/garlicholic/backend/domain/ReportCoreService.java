package com.garlicholic.backend.domain;

import lombok.RequiredArgsConstructor;
import com.garlicholic.backend.api.controller.response.ReportResponse;
import com.garlicholic.backend.storage.ReportEntity;
import com.garlicholic.backend.storage.ReportJpaRepository;
import com.garlicholic.backend.storage.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportCoreService {

    private final UserReader userReader;
    private final ReportJpaRepository reportJpaRepository;

    public List<ReportResponse> readAll(Long userId) {
        List<ReportEntity> reportEntities = reportJpaRepository.findAllByUserIdOrderByCreatedAtDesc(userId);
        UserEntity userEntity = userReader.read(userId);
        return reportEntities.stream()
                .map(reportEntity -> ReportResponse.of(reportEntity, userEntity))
                .toList();
    }

    @Transactional
    public void create(String newHealthStatus, String condition) {
        LocalDateTime todayStart = LocalDate.now().atStartOfDay();
        LocalDateTime todayEnd = LocalDate.now().atTime(LocalTime.MAX);

        Optional<ReportEntity> report = reportJpaRepository
                .findFirstByUserIdAndCreatedAtBetweenOrderByCreatedAtDesc(1L, todayStart, todayEnd);

        if (report.isPresent()) {
            report.get().updateHealthStatus(newHealthStatus);
            report.get().updateConditionText(condition);
        } else {
            reportJpaRepository.save(new ReportEntity(
                    1L, condition, newHealthStatus, false, "none", "메모", LocalDateTime.now()
            ));
        }
    }

}
