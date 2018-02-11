package com.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Weather weather = new Weather();
        weather.addObserver(new Orcs());

        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();

    }
}
