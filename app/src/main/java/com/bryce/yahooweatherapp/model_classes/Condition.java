package com.bryce.yahooweatherapp.model_classes;

import com.google.gson.JsonObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Bryce on 10/15/16.
 */

public class Condition {
    public String code;
    public String date;
    public String temperature;
    public String weatherType;

    public Condition(JsonObject condition) {
        this.code = condition.get("code").toString();

        this.date = condition.get("date").getAsString();


        this.temperature = condition.get("temp").toString();
        this.weatherType = condition.get("text").toString();
    }
}
