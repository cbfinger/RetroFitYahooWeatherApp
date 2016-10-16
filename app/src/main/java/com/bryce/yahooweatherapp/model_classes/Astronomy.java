package com.bryce.yahooweatherapp.model_classes;

import com.google.gson.JsonObject;

/**
 * Created by Bryce on 10/15/16.
 */

public class Astronomy {
    public String sunrise;
    public String sunset;

    public Astronomy(JsonObject astronomy) {
        this.sunrise = astronomy.get("sunrise").getAsString();
        this.sunset = astronomy.get("sunset").getAsString();
    }
}
