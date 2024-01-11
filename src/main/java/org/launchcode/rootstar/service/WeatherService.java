package org.launchcode.rootstar.service;

import com.mysql.cj.xdevapi.JsonArray;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherService {

    public static JSONObject getWeatherData(int locationKey){
        //get postal code locationKey from API
        JsonArray locationData = getLocationData(locationKey);
    }

    //retrieves location key using postal codes
    private static JsonArray getLocationData(int locationKey){
        String urlString = "http://dataservice.accuweather.com/locations/v1/postalcodes/search?apikey=FGZPcs0psWYrremDRCAfgYcOAZhFXxeE&q=" + locationKey ;

        try {
            HttpURLConnection conn = fetchApiResponse(urlString);

            //check response status

            if(conn.getResponseCode() != 200){
                System.out.println("Error: Could not connect to API");
                return null;
            } else {
                //storing API results
                StringBuilder resultJson = new StringBuilder();
                Scanner scanner = new Scanner(conn.getInputStream());
                while(scanner.hasNext()){
                    resultJson.append(scanner.nextLine());
                }

                //close scanner
                scanner.close();

                //close url connection
                conn.disconnect();

                //parse JSON string into JSON obj
                JSONParser parser = new JSONParser();
                JSONObject resultsJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));

                JSONArray locationData = (JSONArray) resultsJsonObj.get("results");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static HttpURLConnection fetchApiResponse(String urlString){
        try {
            //attempt to create connection
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //set request method to GET
            conn.setRequestMethod("GET");

            conn.connect();
            return conn;

        } catch(IOException e){
            e.printStackTrace();
        }

        //if can't make connection, then
        return null;
    }
}
