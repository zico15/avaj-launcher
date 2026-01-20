package avaj.launcher.fleet;

import avaj.launcher.Aircraft;
import avaj.launcher.Coordinates;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
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
                lat += 10;
                h += 2;
                System.out.printf("%s: It's a beautiful day to fly.%n", this);
                break;
            case "RAIN":
                lat += 5;
                System.out.printf("%s: It's raining. Better watch out for lightings.%n", this);
                break;
            case "FOG":
                lat += 1;
                System.out.printf("%s: Better turn on the instruments.%n", this);
                break;
            case "SNOW":
                h -= 7;
                System.out.printf("%s: OMG! Winter is coming!%n", this);
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
