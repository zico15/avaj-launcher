package avaj.launcher.fleet;

import avaj.launcher.Aircraft;
import avaj.launcher.Coordinates;

public class Helicopter extends Aircraft {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        if (weatherTower == null) {
            return;
        }
        String weather = weatherTower.getWeather(coordinates);
        int lon = coordinates.getLongitude();
        int lat = coordinates.getLatitude();
        int h = coordinates.getHeight();
        switch (weather) {
            case "SUN":
                lon += 10;
                h += 2;
                System.out.printf("%s: This is hot.%n", this);
                break;
            case "RAIN":
                lon += 5;
                System.out.printf("%s: It's raining. Better watch out for lightings.%n", this);
                break;
            case "FOG":
                lon += 1;
                System.out.printf("%s: I can't see anything!%n", this);
                break;
            case "SNOW":
                h -= 12;
                System.out.printf("%s: My rotor is going to freeze!%n", this);
                break;
            default:
                break;
        }
        h = Math.max(0, Math.min(100, h));
        this.coordinates = new Coordinates(lon, lat, h);

        if (h == 0) {
            System.out.printf("%s landing.%n", this);
            weatherTower.unregister(this);
        }
    }
}
