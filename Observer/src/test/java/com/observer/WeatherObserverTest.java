package com.observer;

import com.observer.utils.InMemoryAppender;
import com.seitenbau.junit.annotation.ParameterizedTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.provider.MethodSource;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class WeatherObserverTest<O extends WeatherObserver> {

    private InMemoryAppender appender;

    @BeforeEach
    public void setUp() {
        appender = new InMemoryAppender();
    }

    @AfterEach
    public void tearDown() {
        appender.stop();
    }

    private final Supplier<O> factory;

    WeatherObserverTest(final Supplier<O> factory) {
        this.factory = factory;
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testObserver(WeatherType weather, String response) {
        final O observer = this.factory.get();
        assertEquals(0, appender.getLogSize());

        observer.update(weather);
        assertEquals(response, appender.getLastMessage());
        assertEquals(1, appender.getLogSize());
    }

}