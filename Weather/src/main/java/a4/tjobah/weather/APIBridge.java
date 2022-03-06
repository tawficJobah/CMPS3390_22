package a4.tjobah.weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


public class APIBridge {
    private String apiKey,geocodingURL;
    private WeatherModel weatherModel = new WeatherModel();
    private UIBind uiBind;

    public APIBridge(UIBind uiBind){
        this.uiBind = uiBind;
        try(Scanner scanner = new Scanner(new File("api.json"))) {
            StringBuilder apiJSONString = new StringBuilder();
            while(scanner.hasNextLine()){
                apiJSONString.append(scanner.nextLine());
            }
            JSONObject jsonObject = new JSONObject(apiJSONString.toString());
            this.apiKey = jsonObject.getString("apiKey");
            this.geocodingURL = jsonObject.getString("geocodingURL");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } ;
    }

    public void GenerateWeatherModel(String loc){
        HttpClient client = HttpClient.newBuilder().build();
        String URL = String.format(geocodingURL,
                URLEncoder.encode(loc, StandardCharsets.UTF_8),
                apiKey);
        HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(URL))
                        .header("Content-Type", "application/json").build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .thenApply(response -> {
                            JSONArray tmp = new JSONArray(response.body());
                            weatherModel.setLat(tmp.getJSONObject(0).getDouble("lat"));
                            weatherModel.setLon(tmp.getJSONObject(0).getDouble("lon"));
                            uiBind.mapUI(weatherModel);
                            return response.body();
                        });

        System.out.println(URL);
    }

    public WeatherModel getWeatherModel() {
        return weatherModel;
    }

    public void setWeatherModel(WeatherModel weatherModel) {
        this.weatherModel = weatherModel;
    }
}
