package com.example.nimbus.openWeatherApi;

import com.google.gson.annotations.SerializedName;

public class Wind {
    @SerializedName("speed")
    private int speed;

    public int getSpeed() {
        return speed;
    }
}
