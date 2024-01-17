package org.launchcode.rootstar.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Service
public class WeatherService {

    public static JsonObject getWeatherData(String postalCode){

        String locationKey = getLocationData(postalCode);

        //get location key from postal code
//        JSONObject location = (JSONObject) locationData.get(0);
//        String key = locationData.get("Key");

        //API request URL with location key
        String urlString = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + locationKey + "?apikey=FGZPcs0psWYrremDRCAfgYcOAZhFXxeE";

        try{
            //call api and get response
            HttpURLConnection conn = fetchApiResponse(urlString);

            //check response status

            if (conn.getResponseCode() != 200){
                System.out.println("Error: Could not connect to API");
            }

            StringBuilder resultsJson = new StringBuilder();
            Scanner scanner = new Scanner(conn.getInputStream());
            while(scanner.hasNext()){
                //read and store into string builder
                resultsJson.append(scanner.nextLine());
            }
            scanner.close();
            conn.disconnect();

            // parse through data
            JsonParser parser = new JsonParser();
            JsonObject resultsJsonObj = parser.parse(resultsJson.toString()).getAsJsonObject();

            // retrieve five day data
            JsonElement fiveDay = resultsJsonObj.getAsJsonArray("DailyForecasts");

            // confirm that JsonElement contains data
            System.out.println(fiveDay);

            JsonObject weatherData = new JsonObject();

            weatherData.add("five_day", fiveDay);

            // confirm that JsonObject contains data
            System.out.println(weatherData);
            return weatherData;

        } catch(Exception e){
            e.printStackTrace();
        }
//        getLocationData(locationKey);
        return null;
    }

    //retrieves location key using postal codes
    public static String getLocationData(String postalCode){
        System.out.println(postalCode);
        String urlString = "http://dataservice.accuweather.com/locations/v1/postalcodes/search?apikey=FGZPcs0psWYrremDRCAfgYcOAZhFXxeE&q=" + postalCode;
        System.out.println(urlString);

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
                JsonArray jsonArray = JsonParser.parseString(resultJson.toString()).getAsJsonArray();
                System.out.println(jsonArray);
                JsonObject result = jsonArray.get(0).getAsJsonObject();
                System.out.println(result);
                String key = result.get("Key").getAsString();
                System.out.println(key);
                System.out.println(key);
                return key;
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
