package avaj.launcher;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider instance;
    private final String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {}

    public static synchronized WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        if (p_coordinates == null) {
            return "SUN";
        }
        int seed = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
        int idx = Math.abs(seed + new Random(seed).nextInt()) % weather.length;
        return weather[idx];
    }
}
