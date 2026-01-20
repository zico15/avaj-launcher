package avaj.launcher;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    protected final List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        if (p_flyable != null && !observers.contains(p_flyable)) {
            System.out.printf("Tower says: %s registered to weather tower.%n", p_flyable);
            observers.add(p_flyable);
        }
    }

    public void unregister(Flyable p_flyable) {
        if (observers.remove(p_flyable)) {
            System.out.printf("Tower says: %s unregistered from weather tower.%n", p_flyable);
        }
    }

    protected void conditionsChanged() {
        List<Flyable> snapshot = observers.stream().toList();
        for (Flyable f : snapshot) {
            f.updateConditions();
        }
    }
}
