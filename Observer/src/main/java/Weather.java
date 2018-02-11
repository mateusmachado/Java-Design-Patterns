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

    
}
