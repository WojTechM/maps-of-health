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
    private long latitude;
    private long longitude;

    public Location(long id, int hospital_id, long latitude, long longitude) {
        this.id = id;
        this.hospital_id = hospital_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
}
