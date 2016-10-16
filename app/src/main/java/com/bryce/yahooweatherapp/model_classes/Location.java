package com.bryce.yahooweatherapp.model_classes;

import com.google.gson.JsonObject;

/**
 * Created by Bryce on 10/15/16.
 */

public class Location {
    public String city;
    public String country;
    public String region;

    public Location(JsonObject location) {
        this.city = location.get("city").getAsString();
        this.country = location.get("country").getAsString();
        this.region = location.get("region").getAsString();
    }
}
