package org.launchcode.rootstar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Plant extends AbstractEntity {

    @ManyToMany(mappedBy = "gardenPlants")
    private final Set<Garden> gardens = new HashSet<>();

    private String growingZone;

    //TODO: refactor to use enum? Consider alternative to String
    private String annualOrPerennial;

    // CONSTRUCTORS

    public Plant(){}

    public Plant(String growingZone, String annualOrPerennial) {
        super();
        this.growingZone = growingZone;
        this.annualOrPerennial = annualOrPerennial;
    }

    // GETTERS AND SETTERS

    public String getGrowingZone() {
        return growingZone;
    }

    public void setGrowingZone(String growingZone) {
        this.growingZone = growingZone;
    }

    public String getAnnualOrPerennial() {
        return annualOrPerennial;
    }

    public void setAnnualOrPerennial(String annualOrPerennial) {
        this.annualOrPerennial = annualOrPerennial;
    }

}
