package com.example.nimbus.openWeatherApi;

import com.google.gson.annotations.SerializedName;

public class MainApi {
    @SerializedName("temp")
    private double temperatura;

    @SerializedName("pressure")
    private double pressao;

    @SerializedName("humidity")
    private double umidade;

    @SerializedName("temp_min")
    private double temp_min;

    @SerializedName("temp_max")
    private double temp_max;

    @SerializedName("feels_like")
    private double sensTermica; // sensação térmica

    public double getTemperatura() {
        return temperatura;
    }

    public double getPressao() {
        return pressao;
    }

    public double getUmidade() {
        return umidade;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getSensTermica() {
        return sensTermica;
    }
}
