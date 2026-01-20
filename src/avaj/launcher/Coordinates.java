package avaj.launcher;

import avaj.launcher.exceptions.CoordinatesException;

public class Coordinates {
    private final int longitude;
    private final int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
        if (this.height > 100) {
            this.height = 100;
        } else if (this.height < 0) {
            throw new CoordinatesException(this);
        }
    }


    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }


    public int getHeight() {
        return height;
    }


    @Override
    public String toString() {
        return "{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", height=" + height +
                '}';
    }
}
