package com.qentelli.GroupFinalAssessment.utils;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

public class DateUtils {

    // Generate timestamp
    public static String getCurrentTimestamp() {

        return LocalDateTime.now()
                .format(
                DateTimeFormatter
                .ofPattern(
                "yyyyMMdd_HHmmss"));
    }
}