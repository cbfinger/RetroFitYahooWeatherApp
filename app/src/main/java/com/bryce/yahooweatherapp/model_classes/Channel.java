package com.bryce.yahooweatherapp.model_classes;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.security.PublicKey;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Bryce on 10/15/16.
 */

public class Channel {
    public Units units;
    public String title;
    public String link;
    public String description;
    public String language;
    public String lastBuildDate;
    public String ttl;
    public Location location;
    public Wind wind;
    public Atmosphere atmosphere;
    public Astronomy astronomy;
    public YWImageInfo ywImageInfo;
    public Item item;



    public Channel(JsonObject channel) {
        this.units = new Units(channel.getAsJsonObject("units"));
        this.title = channel.get("title").getAsString();
        this.link = channel.get("link").getAsString();
        this.description = channel.get("description").getAsString();
        this.language = channel.get("language").getAsString();

       this.lastBuildDate = channel.get("lastBuildDate").getAsString();
        this.ttl = channel.get("ttl").getAsString();
        this.location = new Location(channel.getAsJsonObject("location"));
        this.wind = new Wind(channel.getAsJsonObject("wind"));
        this.atmosphere = new Atmosphere(channel.getAsJsonObject("atmosphere"));
        this.astronomy = new Astronomy(channel.getAsJsonObject("astronomy"));
        this.ywImageInfo = new YWImageInfo(channel.getAsJsonObject("image"));
        this.item = new Item(channel.getAsJsonObject("item"));
    }

}
