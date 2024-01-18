package org.launchcode.rootstar.models;

import jakarta.persistence.Entity;

@Entity
public class Journal extends AbstractEntity {


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
