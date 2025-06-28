package com.garlicholic.backend.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReportJpaRepository extends JpaRepository<ReportEntity, Long> {
    List<ReportEntity> findAllByUserIdOrderByCreatedAtDesc(Long userId);

    Optional<ReportEntity> findFirstByUserIdAndCreatedAtBetweenOrderByCreatedAtDesc(
            Long userId, LocalDateTime start, LocalDateTime end
    );
}
