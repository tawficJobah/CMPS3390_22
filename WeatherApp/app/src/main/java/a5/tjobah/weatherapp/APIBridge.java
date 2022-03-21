package a5.tjobah.weatherapp;
import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class APIBridge {
    private String apiKey,geocodingURL,weatherURL,weatherIconURL;
    private WeatherModel weatherModel = new WeatherModel();
    private UIBind uiBind;


    public APIBridge(UIBind uiBind, Context context){
        this.uiBind = uiBind;

        String apiJson = null;
        try {
            InputStream is = context.getAssets().open("api.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            apiJson = new String(buffer,StandardCharsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            JSONObject jsonObject = new JSONObject(apiJson);
            this.apiKey = jsonObject.getString("apikey");
            this.geocodingURL = jsonObject.getString("geocodingURL");
            this.weatherURL = jsonObject.getString("weatherURL");
            this.weatherIconURL = jsonObject.getString("weatherIconURL");
            Log.i("JSON","we have a json object");

        } catch (JSONException e) {
            e.printStackTrace();
        }
//        this.uiBind = uiBind;
//        try(Scanner scanner = new Scanner(new File("api.json"))) {
//            StringBuilder apiJSONString = new StringBuilder();
//            while(scanner.hasNextLine()){
//                apiJSONString.append(scanner.nextLine());
//            }
//            JSONObject jsonObject = new JSONObject(apiJSONString.toString());
//            this.apiKey = jsonObject.getString("apiKey");
//            this.geocodingURL = jsonObject.getString("geocodingURL");
//            this.weatherURL = jsonObject.getString("weatherURL");
//            this.weatherIconURL = jsonObject.getString("weatherIconURL");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } ;
    }

    public void GenerateWeatherModel(String loc){
        String url = null;
        try{
            url = String.format(this.geocodingURL,
                    URLEncoder.encode(loc, String.valueOf(StandardCharsets.UTF_8)), this.apiKey);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Log.i("REST",url);
//        HttpClient client = HttpClient.newBuilder().build();
//        String URL = String.format(geocodingURL,
//                URLEncoder.encode(loc, StandardCharsets.UTF_8),
//                apiKey);
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(URL))
//                .header("Content-Type", "application/json").build();
//
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(response -> {
//                    JSONArray tmp = new JSONArray(response.body());
//                    weatherModel.setLat(tmp.getJSONObject(0).getDouble("lat"));
//                    weatherModel.setLon(tmp.getJSONObject(0).getDouble("lon"));
//                    getWeather(String.valueOf(weatherModel.getLat()),String.valueOf(weatherModel.getLon()));
//                    uiBind.mapUI(weatherModel);
//                    return response.body();
//                });
//
//        System.out.println(URL);
    }

    private void getWeather(String lat,String lon){
//        HttpClient client = HttpClient.newBuilder().build();
//        String URL = String.format(weatherURL,
//                lat,lon,apiKey);
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(URL))
//                .header("Content-Type","application/json").build();
//
//        client.sendAsync(request,HttpResponse.BodyHandlers.ofString())
//                .thenApply(response ->{
//                    JSONObject tmp = new JSONObject(response.body());
//                    JSONObject wind = tmp.getJSONObject("wind");
//                    weatherModel.setWindSpeed(wind.getDouble("speed"));
//                    weatherModel.setWindDirection(wind.getInt("deg"));
//
//                    JSONObject weather = tmp.getJSONArray("weather").getJSONObject(0);
//                    weatherModel.setWeatherIcon(String.format(weatherIconURL,weather.getString("icon")));
//                    weatherModel.setWeatherDescription(weather.getString("description"));
//
//
//                    JSONObject main = tmp.getJSONObject("main");
//                    weatherModel.setTemp(main.getDouble("temp"));
//                    weatherModel.setTempMin(main.getDouble("temp_min"));
//                    weatherModel.setHumidity(main.getInt("humidity"));
//                    weatherModel.setPressure(main.getInt("pressure"));
//                    weatherModel.setFeelsLike(main.getDouble("feels_like"));
//                    weatherModel.setTempMax(main.getDouble("temp_max"));
//                    uiBind.mapUI(weatherModel);
//                    return response.body();
//                });

    }

}
