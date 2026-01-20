package avaj.launcher.exceptions;

import avaj.launcher.Scenario;

public class SimulatorException extends RuntimeException {

    public SimulatorException(Scenario scenario){
        super("Simulation error with scenario: " + scenario);
    }


}
