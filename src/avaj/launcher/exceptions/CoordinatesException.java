package avaj.launcher.exceptions;
import avaj.launcher.Coordinates;

public class CoordinatesException extends RuntimeException {

    public CoordinatesException(Coordinates p_coordinates){
        super("Invalid coordinates: " + p_coordinates + ". Longitude and Latitude must be >= 0, Height must be between 0 and 100.");
    }


}
