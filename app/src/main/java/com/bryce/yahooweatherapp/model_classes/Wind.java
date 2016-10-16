package com.bryce.yahooweatherapp.model_classes;

import com.google.gson.JsonObject;

/**
 * Created by Bryce on 10/15/16.
 */

public class Wind {
    public int chill;
    public int direction;
    public int speed;

    public Wind(JsonObject wind) {
        this.chill = wind.get("chill").getAsInt();
        this.direction = wind.get("direction").getAsInt();
        this.speed = wind.get("speed").getAsInt();
    }
}
