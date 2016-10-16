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

public class Forecast {
    public String code;
    public String date;
    public String day;
    public int highTemp;
    public int lowTemp;
    public String weatherType;

    public Forecast(JsonObject forecast) {
        this.code = forecast.get("code").getAsString();
        String dateString = forecast.get("date").getAsString();
        DateFormat serverFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        DateFormat outPutFormat = new SimpleDateFormat("EEEE, MMM d, yyyy");
        Date forecastDate = new Date();
        try {
            forecastDate = serverFormat.parse(dateString);
        }catch (ParseException e){
            e.printStackTrace();
        }
        this.date = outPutFormat.format(forecastDate);
        this.day = forecast.get("day").getAsString();
        this.highTemp = forecast.get("high").getAsInt();
        this.lowTemp = forecast.get("low").getAsInt();
        this.weatherType = forecast.get("text").getAsString();
    }
}
