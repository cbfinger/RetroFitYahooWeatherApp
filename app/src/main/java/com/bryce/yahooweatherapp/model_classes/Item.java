package com.bryce.yahooweatherapp.model_classes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Bryce on 10/15/16.
 */

public class Item {
    public String title;
    public double latitude;
    public double longitude;
    public String link;
    public String pubDate;
    public Condition condition;
    public ArrayList<Forecast> forecasts;


    public Item(JsonObject item) {
        this.title =item.get("title").getAsString();
        this.latitude = item.get("lat").getAsDouble();
        this.longitude = item.get("long").getAsDouble();
        this.link = item.get("link").getAsString();
        this.pubDate = item.get("pubDate").getAsString();
        this.condition = new Condition(item.getAsJsonObject("condition"));
        JsonArray tempForecastList = item.getAsJsonArray("forecast");
        this.forecasts = new ArrayList<Forecast>();
        for (int i=0;i < tempForecastList.size();i++){
            Forecast forecast = new Forecast(tempForecastList.get(i).getAsJsonObject());
            this.forecasts.add(forecast);
        }

    }
}
