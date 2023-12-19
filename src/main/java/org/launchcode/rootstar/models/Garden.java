package org.launchcode.rootstar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Garden extends AbstractEntity {

    @ManyToMany
    private List<Seed> seeds;

    @ManyToMany
    private List<Plant> plants;

    @ManyToOne
    private Soil soil;

    // CONSTRUCTORS

    public Garden(){}

    public Garden(List<Seed> seeds, List<Plant> plants, Soil soil) {
        super();
        this.seeds = seeds;
        this.plants = plants;
        this.soil = soil;
    }

    // GETTERS AND SETTERS

    //TODO: Refactor getters and setters once we establish the many to many relationships

    public List<Seed> getSeeds() {
        return seeds;
    }

    public void setSeeds(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }
}
