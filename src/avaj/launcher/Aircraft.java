package avaj.launcher;

public abstract class Aircraft implements Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected WeatherTower weatherTower;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    @Override
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        p_tower.register(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")";
    }
}
