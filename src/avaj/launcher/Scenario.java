package avaj.launcher;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public record Scenario(int times, List<Flyable> fleet) {

    public static Scenario parse(File file) throws Exception {
        if (file == null || !file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("Invalid scenario file.");
        }
        var lines = Files.readAllLines(file.toPath());
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("Scenario file is empty.");
        }
        int times = Integer.parseInt(lines.getFirst().trim());
        List<Flyable> list = new ArrayList<>();
        for (String line : lines.subList(1, lines.size())) {
            String trimmed = line.trim();
            if (trimmed.isEmpty()) continue;
            String[] parts = trimmed.split("\\s+");
            if (parts.length < 5) {
                throw new IllegalArgumentException("Invalid aircraft line: " + trimmed);
            }
            list.add(AircraftFactory.getInstance().newAircraft(
                    parts[0], parts[1],
                    new Coordinates(
                            Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]),
                            Integer.parseInt(parts[4])
                    )
            ));
        }
        return new Scenario(times, list);
    }
}
