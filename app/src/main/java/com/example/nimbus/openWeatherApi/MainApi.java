package com.example.nimbus.openWeatherApi;

import com.google.gson.annotations.SerializedName;

public class MainApi {
    @SerializedName("temp")
    private int temperatura;

    @SerializedName("pressure")
    private int pressao;

    @SerializedName("humidity")
    private int umidade;

    @SerializedName("temp_min")
    private int temp_min;

    @SerializedName("temp_max")
    private int temp_max;

    public int getTemperatura() {
        return temperatura;
    }

    public int getPressao() {
        return pressao;
    }

    public int getUmidade() {
        return umidade;
    }

    public int getTemp_min() {
        return temp_min;
    }

    public int getTemp_max() {
        return temp_max;
    }
}
