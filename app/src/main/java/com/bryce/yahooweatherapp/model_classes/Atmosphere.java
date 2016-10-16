package com.bryce.yahooweatherapp.model_classes;

import com.google.gson.JsonObject;

/**
 * Created by Bryce on 10/15/16.
 */

public class Atmosphere {
    public float humidity;
    public float pressure;
    public float rising;
    public float visibility;

    public Atmosphere(JsonObject atmosphere) {
        this.humidity = atmosphere.get("humidity").getAsFloat();
        this.pressure = atmosphere.get("pressure").getAsFloat();
        this.rising = atmosphere.get("rising").getAsFloat();
        this.visibility = atmosphere.get("visibility").getAsFloat();
    }

}
