package org.launchcode.rootstar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Seed extends AbstractEntity {

    @ManyToMany(mappedBy = "gardenSeeds")
    private final List<Garden> gardens = new ArrayList<>();

    private String growingZone;

    private int daysToGermination;

    //TODO: refactor to use enum? Consider alternative to String
    private String annualOrPerennial;

    // CONSTRUCTORS
    public Seed(){}

    public Seed(String growingZone, int daysToGermination, String annualOrPerennial) {
        super();
        this.growingZone = growingZone;
        this.daysToGermination = daysToGermination;
        this.annualOrPerennial = annualOrPerennial;
    }

    // GETTERS AND SETTERS
    public String getGrowingZone() {
        return growingZone;
    }

    public void setGrowingZone(String growingZone) {
        this.growingZone = growingZone;
    }

    public int getDaysToGermination() {
        return daysToGermination;
    }

    public void setDaysToGermination(int daysToGermination) {
        this.daysToGermination = daysToGermination;
    }

    public String getAnnualOrPerennial() {
        return annualOrPerennial;
    }

    public void setAnnualOrPerennial(String annualOrPerennial) {
        this.annualOrPerennial = annualOrPerennial;
    }
}
