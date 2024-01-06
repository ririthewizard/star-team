package org.launchcode.rootstar.service;


import org.launchcode.rootstar.models.Garden;

import java.util.ArrayList;

public class SearchFunctions {

    public static ArrayList<Garden> findByColumnAndValue(String column, String value, Iterable<Garden> allGardens) {

        ArrayList<Garden> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){ return (ArrayList<Garden>) allGardens; }

        if (column.equals("all")){
            results = findByValue(value, allGardens);
            return results;
        }

        for (Garden garden : allGardens) {
            String gardenValue = getFieldValue(garden, column);

            if (gardenValue != null && gardenValue.toLowerCase().contains(value.toLowerCase())){
                results.add(garden);
            }
        }
        return results;
    }

    public static String getFieldValue(Garden garden, String fieldName) {
        String fieldValue = "";
        if (fieldName.equals("name")){
            fieldValue = garden.getName();
        } else if (fieldName.equals("seeds")) {

            fieldValue = garden.getGardenSeeds().toString();
        } else if (fieldName.equals("plants")) {
            fieldValue = garden.getGardenPlants().toString();

        }

        return fieldValue;
    }

    public static ArrayList<Garden> findByValue(String value, Iterable<Garden> allGardens) {
        ArrayList<Garden> results = new ArrayList<>();

        for (Garden garden: allGardens){
            if (garden.getName().toLowerCase().contains(value.toLowerCase())){
                results.add(garden);

            } else if (garden.getGardenSeeds().toString().toLowerCase().contains(value.toLowerCase())){
                results.add(garden);
            } else if (garden.getGardenPlants().toString().toLowerCase().contains(value.toLowerCase())){
                results.add(garden);
            } else if (garden.getGardenSoil().toString().toLowerCase().contains(value.toLowerCase())){

                results.add(garden);
            }
        }
        return results;
    }
}
