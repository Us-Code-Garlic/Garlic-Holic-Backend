package com.garlicholic.backend.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DementiaHistoryJpaRepository extends JpaRepository<DementiaHistoryEntity, Long> {

    @Query("""
        SELECT dh.userId FROM DementiaHistoryEntity dh
        WHERE dh.createdAt BETWEEN :yesterdayStart AND :yesterdayEnd
    """)
    List<Long> findDailyReportTargetUserIds(
            @Param("yesterdayStart") LocalDateTime yesterdayStart,
            @Param("yesterdayEnd") LocalDateTime yesterdayEnd
    );

    List<DementiaHistoryEntity> findAllByUserIdAndCreatedAtBetween(Long userId, LocalDateTime start, LocalDateTime end);

}
