package avaj;

import avaj.launcher.Flyable;
import avaj.launcher.Scenario;
import avaj.launcher.WeatherTower;
import avaj.launcher.exceptions.SimulatorException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Simulator {

    private final Scenario scenario;

    public Simulator(String[] args) throws Exception {
        this.scenario = Scenario.parse(new File(args[0]));
    }

    public void run() {
        if (scenario.fleet().isEmpty()) {
            throw new SimulatorException(scenario);
        }
        PrintStream stdout = System.out;
        File outFile = new File("simulation.txt");
        try {
            PrintStream fileOut = new PrintStream(new FileOutputStream(outFile, false));
            System.setOut(fileOut);

            WeatherTower tower = new WeatherTower();
            for (Flyable f : scenario.fleet()) {
                f.registerTower(tower);
            }
            for (int i = 0; i < scenario.times(); i++) {
                tower.changeWeather();
            }

            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            System.setOut(stdout);
        }
    }


    public static void main(String[] args) {
        try {
            new Simulator(args).run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
