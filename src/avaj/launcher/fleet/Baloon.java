package avaj.launcher.fleet;

import avaj.launcher.Aircraft;
import avaj.launcher.Coordinates;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
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
                lon += 2;
                h += 4;
                System.out.printf("%s: Let's enjoy the good weather and take some pics.%n", this);
                break;
            case "RAIN":
                h -= 5;
                System.out.printf("%s: Damn you rain! You messed up my balloon.%n", this);
                break;
            case "FOG":
                h -= 3;
                System.out.printf("%s: I can't see anything!%n", this);
                break;
            case "SNOW":
                h -= 15;
                System.out.printf("%s: It's snowing. We're gonna crash.%n", this);
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
