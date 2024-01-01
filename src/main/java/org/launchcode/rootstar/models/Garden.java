package org.launchcode.rootstar.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Garden extends AbstractEntity {

    @ManyToMany(mappedBy = "gardens")
//    @JoinTable(name = "garden_seed",
//            joinColumns = @JoinColumn(name = "garden_id"),
//            inverseJoinColumns = @JoinColumn(name = "seed_id"))
    private Set<Seed> gardenSeeds;

    @ManyToMany(mappedBy = "gardens")
//    @JoinTable(name = "garden_plant",
//            joinColumns = @JoinColumn(name = "garden_id"),
//            inverseJoinColumns = @JoinColumn(name = "plant_id"))
    private Set<Plant> gardenPlants;

    @ManyToOne
    @JoinColumn(name = "soil_id")
    private Soil gardenSoil;
    // CONSTRUCTORS

    public Garden(){}

    public Garden(Set<Seed> seeds, Set<Plant> plants, Soil soil) {
        super();
        this.gardenSeeds = seeds;
        this.gardenPlants = plants;
        this.gardenSoil = soil;
    }

    // GETTERS AND SETTERS

    //TODO: Refactor getters and setters once we establish the many to many relationships

    public Set<Seed> getSeeds() {
        return gardenSeeds;
    }

    public void setSeeds(Set<Seed> seeds) {
        this.gardenSeeds = seeds;
    }

    public Set<Plant> getPlants() {
        return gardenPlants;
    }

    public void setPlants(Set<Plant> plants) {
        this.gardenPlants = plants;
    }

    public Soil getSoil() {
        return gardenSoil;
    }

    public void setSoil(Soil soil) {
        this.gardenSoil = soil;
    }
}
