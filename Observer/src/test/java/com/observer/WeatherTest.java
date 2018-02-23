package com.observer;

import com.observer.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WeatherTest {

    private InMemoryAppender appender;

    @BeforeEach
    public void setUp() {
        appender = new InMemoryAppender(Weather.class);
    }

    @AfterEach
    public void tearDown() {
        appender.stop();
    }

    @Test
    public void testAddRemoveObserver() {
        final WeatherObserver observer = mock(WeatherObserver.class);

        final Weather weather = new Weather();
        weather.addObserver(observer);
        verifyZeroInteractions(observer);

        weather.timePasses();
        assertEquals("The weather changed to rainy.", appender.getLastMessage());
        verify(observer).update(WeatherType.RAINY);

        weather.removeObserver(observer);
        weather.timePasses();
        assertEquals("The weather changed to windy.", appender.getLastMessage());

        verifyNoMoreInteractions(observer);
        assertEquals(2, appender.getLogSize());
    }

    @Test
    public void testTimePasses() {
        final WeatherObserver observer = mock(WeatherObserver.class);
        final Weather weather = new Weather();
        weather.addObserver(observer);

        final InOrder inOrder = inOrder(observer);
        final WeatherType[] weatherTypes = WeatherType.values();
        for (int i = 1; i < 20; i++) {
            weather.timePasses();
            inOrder.verify(observer).update(weatherTypes[i % weatherTypes.length]);
        }

        verifyNoMoreInteractions(observer);
    }

}
