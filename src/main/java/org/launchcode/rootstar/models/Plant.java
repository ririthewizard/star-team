package org.launchcode.rootstar.models;

public class Plant extends AbstractEntity {

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
