package org.launchcode.rootstar.models;


import java.util.ArrayList;

public class SearchFunctionsSeed {

    public static ArrayList<Seed> findByColumnAndValue(String column, String value, Iterable<Seed> allSeeds) {

        ArrayList<Seed> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){ return (ArrayList<Seed>) allSeeds; }

        if (column.equals("all")){
            results = findByValue(value, allSeeds);
            return results;
        }

        for (Seed seed : allSeeds) {
            String seedValue = getFieldValue(seed, column);

            if (seedValue != null && seedValue.toLowerCase().contains(value.toLowerCase())){
                results.add(seed);
            }
        }
        return results;
    }

    public static String getFieldValue(Seed seed, String fieldName) {
        String fieldValue = "";
        if (fieldName.equals("name")){
            fieldValue = seed.getName();
        } else if (fieldName.equals("growing zone")) {
            fieldValue = seed.getGrowingZone();
        } else if (fieldName.equals("annual") || fieldName.equals("perennial")) {
            fieldValue = seed.getAnnualOrPerennial();
        }

        return fieldValue;
    }

    public static ArrayList<Seed> findByValue(String value, Iterable<Seed> allSeeds) {
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
