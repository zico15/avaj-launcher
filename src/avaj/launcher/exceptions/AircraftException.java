package avaj.launcher.exceptions;
import avaj.launcher.Coordinates;

public class AircraftException extends RuntimeException {

    public AircraftException(String p_type, String p_name, Coordinates p_coordinates){
        super("Invalid aircraft parameters: Type=" + p_type + ", Name=" + p_name + ", Coordinates=" + p_coordinates);
    }


}
