package com.example.nimbus.model;

public class City {
    private String nome, temp, descricao;
    private String windSpeed, temp_max, temp_min, pressure, humidity; // segunda tela

    public City(String nome, String temp, String descricao, String windSpeed, String temp_max, String temp_min, String pressure, String humidity) {
        this.nome = nome;
        this.temp = temp;
        this.descricao = descricao;
        this.windSpeed = windSpeed;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.pressure = pressure;
        this.humidity = humidity;
    }
}
