package org.launchcode.rootstar.models;


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
            fieldValue = garden.getSeeds().toString();
        } else if (fieldName.equals("plants")) {
            fieldValue = garden.getPlants().toString();
        }

        return fieldValue;
    }

    public static ArrayList<Garden> findByValue(String value, Iterable<Garden> allGardens) {
        ArrayList<Garden> results = new ArrayList<>();

        for (Garden garden: allGardens){
            if (garden.getName().toLowerCase().contains(value.toLowerCase())){
                results.add(garden);
            } else if (garden.getSeeds().toString().toLowerCase().contains(value.toLowerCase())){
                results.add(garden);
            } else if (garden.getPlants().toString().toLowerCase().contains(value.toLowerCase())){
                results.add(garden);
            }
        }
        return results;
    }
}
