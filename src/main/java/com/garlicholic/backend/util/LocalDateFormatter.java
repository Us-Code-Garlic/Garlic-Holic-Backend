package com.garlicholic.backend.util;

import java.time.LocalDateTime;

public class LocalDateFormatter {

    public static LocalDateTime fromTimestamp(String timestamp) {
        if (timestamp == null) return null;
        return LocalDateTime.parse(timestamp);
    }

    public static String fromLocalDateTime(LocalDateTime localDateTime) {
        if (localDateTime == null) return null;
        return localDateTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
    }

}
