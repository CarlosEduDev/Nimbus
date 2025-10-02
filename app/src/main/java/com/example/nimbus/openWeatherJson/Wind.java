package com.example.nimbus.openWeatherJson;

import com.google.gson.annotations.SerializedName;

public class Wind {
    @SerializedName("speed")
    private int speed;

    public int getSpeed() {
        return speed;
    }
}
