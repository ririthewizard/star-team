package org.launchcode.rootstar.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Garden extends AbstractEntity {

    @ManyToMany
    @JoinTable(
            name = "garden_seed",
            joinColumns = @JoinColumn(name = "garden_id"),
            inverseJoinColumns = @JoinColumn(name = "seed_id")
    )
    private List<Seed> gardenSeeds;

    @ManyToMany
    @JoinTable(
            name = "garden_plant",
            joinColumns = @JoinColumn(name = "garden_id"),
            inverseJoinColumns = @JoinColumn(name = "plant_id")
    )
    private List<Plant> gardenPlants;

    @ManyToOne
    @JoinColumn(name = "soil_id")
    private Soil gardenSoil;
    // CONSTRUCTORS

    public Garden(){}

    public Garden(List<Seed> seeds, List<Plant> plants, Soil soil) {
        super();
        this.gardenSeeds = seeds;
        this.gardenPlants = plants;
        this.gardenSoil = soil;
    }

    // GETTERS AND SETTERS

    //TODO: Refactor getters and setters once we establish the many to many relationships

    public List<Seed> getGardenSeeds() {
        return gardenSeeds;
    }

    public void setGardenSeeds(List<Seed> seeds) {
        this.gardenSeeds = seeds;
    }

    public List<Plant> getGardenPlants() {
        return gardenPlants;
    }

    public void setGardenPlants(List<Plant> plants) {
        this.gardenPlants = plants;
    }

    public Soil getGardenSoil() {
        return gardenSoil;
    }

    public void setGardenSoil(Soil soil) {
        this.gardenSoil = soil;
    }
}
