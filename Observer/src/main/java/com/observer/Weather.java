package com.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Weather {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private WeatherType currentWeather;
    private List<WeatherObserver> observers;

    public Weather() {
        observers = new ArrayList<WeatherObserver>();
        currentWeather = WeatherType.SUNNY;
    }

    public void addObserver(WeatherObserver obs){
        observers.add(obs);
    }

    public void removeObserver(WeatherObserver obs){
        observers.remove(obs);
    }

    public void timePasses(){
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        LOGGER.info("The weather changed to {}.", currentWeather);
        notifyObserver();
    }

    private void notifyObserver() {
        for (WeatherObserver obs : observers) {
            obs.update(currentWeather);
        }
    }

}
