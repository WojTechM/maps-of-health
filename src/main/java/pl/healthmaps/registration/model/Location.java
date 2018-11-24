package pl.healthmaps.registration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int hospital_id;
    private double latitude;
    private double longitude;

    public Location(long id, int hospital_id, long latitude, long longitude) {
        this.id = id;
        this.hospital_id = hospital_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(int hospital_id, double latitude, double longitude) {
        this.hospital_id = hospital_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }


    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }


    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
}
