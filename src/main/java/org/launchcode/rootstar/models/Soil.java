package org.launchcode.rootstar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Soil extends AbstractEntity {

    @OneToMany(mappedBy = "gardenSoil")
    private final List<Garden> gardens = new ArrayList<>();

    private String type;

    // CONSTRUCTORS

    public Soil(){}

    public Soil(String type) {
        super();
        this.type = type;
    }

    // GETTERS AND SETTERS

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
