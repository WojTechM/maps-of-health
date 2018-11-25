package pl.healthmaps.registration.model;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;

public class DTOLocation {

    private double latitude;
    private double longitude;

    public DTOLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "DTOLocation{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
