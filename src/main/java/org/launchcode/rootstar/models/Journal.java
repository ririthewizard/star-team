package org.launchcode.rootstar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Journal extends AbstractEntity {

//    @OneToMany(mappedBy = "gardenSoil")
//    private final List<Garden> gardens = new ArrayList<>();

    private String season;

    // CONSTRUCTORS

    public Journal(){}

    public Journal(String season) {
        super();
        this.season = season;
    }

    // GETTERS AND SETTERS

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
