package org.launchcode.rootstar.models;


import java.util.ArrayList;

public class SearchFunctions {

    public static ArrayList<Seed> findByColumnAndValue(String column, String value, Iterable<Seed> allSeeds){

        ArrayList<Seed> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){ return (ArrayList<Seed>) allSeeds; }

        if (column.equals("all")){
            results = findByValue(value, seeds);
            return results;
        }
    }

    public static ArrayList<Seed> findByValue(String value, Iterable<Seed> allSeeds){
        ArrayList<Seed> results = new ArrayList<>();

        for (Seed seed: allSeeds){
            if (seed.getName().toLowerCase().contains(value.toLowerCase())){
                results.add(seed);
            } else if (seed.getGrowingZone().toLowerCase().contains(value.toLowerCase())){
                results.add(seed);
            } else if (seed.getAnnualOrPerennial().toLowerCase().contains(value.toLowerCase())){
                results.add(seed);
            }
        }
        return results;
    }
}
