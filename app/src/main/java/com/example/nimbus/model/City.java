package com.example.nimbus.model;

import java.io.Serializable;

public class City implements Serializable {
    private String nome, temp, descricao;
    private String windSpeed, temp_max, temp_min, pressure, humidity; // segunda tela

    public City(String nome, String temp, String desc, String windSpeed, String temp_max, String temp_min, String pressure, String humidity) {
        this.nome = nome;
        this.temp = temp;
        this.descricao = desc;
        this.windSpeed = windSpeed;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public String getNome() {
        return nome;
    }

    public String getTemp() {
        return temp;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }
}
