package com.vodafone.er.ecom.proxy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.OptionalLong;

/**
 * Created by Ravi Aghera
 */
@Component("dateProcessor")
public class EpaDateTimeProcessor {

    private static final Logger logger = LoggerFactory.getLogger(EpaDateTimeProcessor.class);

    //Keep the same format everywhere
    private static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss:SSS";

    public String getLocalDateTimeString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }

    public Optional<LocalDateTime> getDateTimeFromString(String dateTimeString) {
        Optional<LocalDateTime> result = Optional.empty();
        try {
            result = Optional.of(LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
        } catch (DateTimeParseException ex) {
            //Not fatal error
            logger.warn("Could not parse date using dateTimeString="
                    + dateTimeString + ". Returning Empty result", ex);
        }
        return result;
    }

    public OptionalLong calculateDurationAsMillis(String startTime, String finishTime) {
        OptionalLong result = OptionalLong.empty();
            Optional<LocalDateTime> start = getDateTimeFromString(startTime);
            Optional<LocalDateTime> finish = getDateTimeFromString(finishTime);
            if(start.isPresent() && finish.isPresent()) {
                result = OptionalLong.of(Duration.between(start.get(), finish.get())
                        .toMillis());
            }
        return result;
    }
}
