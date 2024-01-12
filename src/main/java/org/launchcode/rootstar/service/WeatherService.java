package org.launchcode.rootstar.service;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Service
public class WeatherService {

    public static JSONObject getWeatherData(int locationKey){

        JSONArray locationData = getLocationData(locationKey);

        //get location key from postal code
        JSONObject location = (JSONObject) locationData.get(0);
        String key = (String) location.get("Key");

        //API request URL with location key
        String urlString = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/&q=28204_PC?apikey=FGZPcs0psWYrremDRCAfgYcOAZhFXxeE&q=" + key;

        try{
            //call api and get response
            HttpURLConnection conn = fetchApiResponse(urlString);

            //check response status

            if (conn.getResponseCode() != 200){
                System.out.println("Error: Could not connect to API");
                return null;
            }

            StringBuilder resultsJson = new StringBuilder();
            Scanner scanner = new Scanner(conn.getInputStream());
            while(scanner.hasNext()){
                //read and store into string builder
                resultsJson.append(scanner.nextLine());
            }
            scanner.close();
            conn.disconnect();

            //parse through data
            JSONParser parser = new JSONParser();
            JSONObject resultsJsonObj = (JSONObject) parser.parse(String.valueOf(resultsJson));

            //retrieve five day data
            JSONObject fiveDay = (JSONObject) resultsJsonObj.get("DailyForecasts");

            JSONObject weatherData = new JSONObject();
            weatherData.put("five_day", fiveDay);

        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    //retrieves location key using postal codes
    public static JSONArray getLocationData(int locationKey){
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
                return locationData;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        //return null if can't find location
        return null;
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
