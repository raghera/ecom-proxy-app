package com.vodafone.er.ecom.proxy.service;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Ravi Aghera
 */
@Component("dateProcessor")
public class EpaDateTimeProcessor {

    //Keep the same format everywhere
    private static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss:SSS";

    public String getLocalDateTimeString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }

    public LocalDateTime getDateTimeFromString(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }

    public long calculateDurationAsMillis(String startTime, String finishTime) {
        return Duration.between(getDateTimeFromString(startTime), getDateTimeFromString(finishTime))
                .toMillis();
    }
}
