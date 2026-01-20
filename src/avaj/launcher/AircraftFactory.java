package avaj.launcher;

import avaj.launcher.exceptions.AircraftException;
import avaj.launcher.fleet.Baloon;
import avaj.launcher.fleet.Helicopter;
import avaj.launcher.fleet.JetPlane;

public class AircraftFactory {
    private static AircraftFactory instance;
    private static long idCounter = 0;

    private AircraftFactory() {}

    public static synchronized AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    private static synchronized long nextId() {
        return ++idCounter;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        long id = nextId();
        if ("Helicopter".equalsIgnoreCase(p_type)) {
            return new Helicopter(id, p_name, p_coordinates);
        } else if ("JetPlane".equalsIgnoreCase(p_type)) {
            return new JetPlane(id, p_name, p_coordinates);
        } else if ("Baloon".equalsIgnoreCase(p_type)) {
            return new Baloon(id, p_name, p_coordinates);
        }
        throw new AircraftException(p_type, p_name, p_coordinates);
    }
}
