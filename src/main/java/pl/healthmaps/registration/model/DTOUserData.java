package pl.healthmaps.registration.model;

import javax.persistence.Entity;
import java.util.Arrays;

public class DTOUserData {

    private String[] illnesses;
    private DTOLocation location;

    public DTOUserData(String[] illnesses, DTOLocation location) {
        this.illnesses = illnesses;
        this.location = location;
    }

    public String[] getIllnesses() {
        return illnesses;
    }

    public void setIllnesses(String[] illnesses) {
        this.illnesses = illnesses;
    }

    public DTOLocation getLocation() {
        return location;
    }

    public void setLocation(DTOLocation location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "DTOUserData{" +
                "illnesses=" + Arrays.toString(illnesses) +
                ", location=" + location +
                '}';
    }
}
