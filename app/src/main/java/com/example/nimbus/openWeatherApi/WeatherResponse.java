package com.example.nimbus.openWeatherApi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {
    @SerializedName("name")
    private String name;
    @SerializedName("main")
    private MainApi mainApi;
    @SerializedName("weather")
    private List<Weather> weatherList;
    private Wind wind;

    public String getName() {
        return name;
    }

    public MainApi getMainApi() {
        return mainApi;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public Wind getWind() {
        return wind;
    }
}
