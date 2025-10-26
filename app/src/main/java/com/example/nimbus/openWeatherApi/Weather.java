package com.example.nimbus.openWeatherApi;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("id")
    private int id;

    @SerializedName("main") // nuvens, ensolarado, etc.
    private String main;

    @SerializedName("description")
    private String descricao;

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescricao() {
        return descricao;
    }
}
