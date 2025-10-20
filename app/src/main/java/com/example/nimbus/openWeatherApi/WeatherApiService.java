package com.example.nimbus.openWeatherApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {
    @GET("data/2.5/weather")
    Call<WeatherResponse> getCurrentWeather(
            @Query("q") String city,
            @Query("appid") String ApiKey,
            @Query("units") String units,
            @Query("lang") String idioma
    );
}
