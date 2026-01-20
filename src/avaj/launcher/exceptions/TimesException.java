package avaj.launcher.exceptions;
import avaj.launcher.Coordinates;

public class TimesException extends RuntimeException {

    public TimesException(int p_times){
        super("Invalid simulation times: " + p_times);
    }


}
