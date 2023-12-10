package org.launchcode.rootstar.models;

public class Soil {

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
