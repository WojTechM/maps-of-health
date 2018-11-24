package pl.healthmaps.registration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private long hospital_id;

    public Doctor(String firstName, String lastName, long hospital_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hospital_id = hospital_id;
    }

    public Doctor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(long hospital_id) {
        this.hospital_id = hospital_id;
    }
}
