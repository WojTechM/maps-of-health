package pl.healthmaps.registration.model;

import com.google.gson.Gson;

import javax.persistence.*;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;

    @OneToOne
    private Location location;

    public Hospital(String name, String description, Location location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toGson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
