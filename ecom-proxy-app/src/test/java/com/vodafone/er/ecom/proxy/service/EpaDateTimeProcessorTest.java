package com.vodafone.er.ecom.proxy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.OptionalLong;

import static org.junit.Assert.*;

/**
 * Created by Ravi Aghera
 */
@RunWith(MockitoJUnitRunner.class)
public class EpaDateTimeProcessorTest {

    @InjectMocks
    private EpaDateTimeProcessor epaDateTimeProcessor;

    @Test
    public void shouldCreateDateTimeStringAndConvertBackToOriginalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        String dateString = epaDateTimeProcessor.getLocalDateTimeString(now);
        Optional<LocalDateTime> result = epaDateTimeProcessor.getDateTimeFromString(dateString);
        assertTrue(result.isPresent());
        assertEquals(now, result.get());
    }

    @Test
    public void shouldReturnEmptyWhenCannotParseDateFromString() {
        Optional<LocalDateTime> result = epaDateTimeProcessor.getDateTimeFromString("asdfdshfkd");
        assertNotNull(result);
        assertFalse(result.isPresent());

    }

    @Test
    public void shouldCalculateDurationCorrectly() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowPlusSeconds = now.plus(Duration.ofSeconds(32));

        String timeString1 = epaDateTimeProcessor.getLocalDateTimeString(now);
        String timeString2 = epaDateTimeProcessor.getLocalDateTimeString(nowPlusSeconds);

        OptionalLong result = epaDateTimeProcessor.calculateDurationAsMillis(timeString1, timeString2);

        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(result.getAsLong(), 32000);
    }

    @Test
    public void shouldReturnEmptyWhenDatesNotParsable() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowPlusSeconds = now.plus(Duration.ofSeconds(32));

        String rubbish = "rubbishDateString";
        String timeString2 = epaDateTimeProcessor.getLocalDateTimeString(nowPlusSeconds);

        OptionalLong result = epaDateTimeProcessor.calculateDurationAsMillis(rubbish, timeString2);

        assertNotNull(result);
        assertFalse(result.isPresent());
    }

}
