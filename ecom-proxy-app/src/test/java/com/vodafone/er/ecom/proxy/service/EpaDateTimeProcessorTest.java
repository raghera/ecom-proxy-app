package com.vodafone.er.ecom.proxy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

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
        LocalDateTime result = epaDateTimeProcessor.getDateTimeFromString(dateString);
        assertEquals(now, result);
    }

    @Test
    public void shouldCalculateDurationCorrectly() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowPlusSeconds = now.plus(Duration.ofSeconds(32));

        String timeString1 = epaDateTimeProcessor.getLocalDateTimeString(now);
        String timeString2 = epaDateTimeProcessor.getLocalDateTimeString(nowPlusSeconds);

        long result = epaDateTimeProcessor.calculateDurationAsMillis(timeString1, timeString2);

        assertEquals(result, 32000);
    }

}
