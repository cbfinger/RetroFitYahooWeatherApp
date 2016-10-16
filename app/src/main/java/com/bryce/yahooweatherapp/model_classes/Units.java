package com.bryce.yahooweatherapp.model_classes;

import com.google.gson.JsonObject;

/**
 * Created by Bryce on 10/15/16.
 */

public class Units {
    public String distance;
    public String pressure;
    public String speed;
    public String temperature;

    public Units(JsonObject units) {
        this.distance = units.get("distance").getAsString();
        this.pressure = units.get("pressure").getAsString();
        this.speed = units.get("speed").getAsString();
        this.temperature = units.get("temperature").getAsString();
    }
}
