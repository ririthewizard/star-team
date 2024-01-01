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
public class Seed extends AbstractEntity {

    @ManyToMany
    @JoinTable(name = "garden_seed",
            joinColumns = @JoinColumn(name = "seed_id"),
            inverseJoinColumns = @JoinColumn(name = "garden_id"))
    private final Set<Garden> gardens = new HashSet<>();

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
